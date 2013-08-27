package Gerenciamento;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.poo.projeto.Funcionario;
import br.ufpb.poo.projeto.Pessoa;

import Exception.CampoInvalidoException;
import Exception.FuncionarioInexistenteException;
import Exception.FuncionarioJaCadastradoException;

public class GerenteFuncionario {

	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public void addFuncionario(Funcionario funcionario) {
		if(funcionarioJaCadastrado(funcionario)){
			throw new FuncionarioJaCadastradoException("Funcionario ja cadastrado!!!");
		}
		if(funcionario.getNome() == null){
			throw new CampoInvalidoException("Funcionario sem nome!!!");
		}
		if(funcionario.getMatricula() == 0){
			throw new CampoInvalidoException("Funcionario sem matricula!!!");
		}
		if(funcionario.getFuncao() == null){
			throw new CampoInvalidoException("Funcionario sem função");
		}
		if(funcionario.cpf().getCpf() == null){
			throw new CampoInvalidoException("Funcionario sem cpf");
		}
		if(!funcionario.cpf().validarCpf()){
			throw new CampoInvalidoException("Funcionario com CPF invalido!!!");
		}
		if(cpfJaCadastrado(funcionario)){
			throw new CampoInvalidoException("Funcionario com CPF ja cadastrado!!!");
		}
		funcionarios.add(funcionario);
	}

	private boolean funcionarioJaCadastrado(Funcionario funcionario) {
		boolean cadastrado = false;
		for (Funcionario f : funcionarios) {
			if(f.equals(funcionario)){
				cadastrado = true;
			}
		}
		return cadastrado;
	}

	public int quantidadeDefuncionarios() {
		return funcionarios.size();
	}

	public Funcionario getFuncionario(int pos) {
		return funcionarios.get(pos);
	}
	
	private boolean cpfJaCadastrado(Funcionario funcionario) {
		boolean cadastrado = false;
		for(Pessoa a: funcionarios){
			if(a.cpf().getCpf().equals(funcionario.cpf().getCpf())){
				cadastrado = true;
			}
		}
		return cadastrado;
	}

	public void removeFuncionario(Funcionario funcionario) {
		if(quantidadeDefuncionarios() == 0){
			throw new FuncionarioInexistenteException("Não existe funcionario para remover!!!");
		}
		if(!exiteFuncionario(funcionario)){
			throw new FuncionarioInexistenteException("Funcionario inexistente!!!");
		}
		funcionarios.remove(funcionario);
	}

	public boolean exiteFuncionario(Funcionario funcionario){
		boolean existe = false;
		for(Funcionario f :funcionarios){
			if(f.equals(funcionario)){
				existe = true;
			}
		}
		return existe;
	}

	public boolean validarCpfDeFuncionario(int pos) {
		boolean valido = false;
		valido = getFuncionario(pos).cpf().validarCpf();
		return valido;
	}
}
