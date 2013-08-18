package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

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

}
