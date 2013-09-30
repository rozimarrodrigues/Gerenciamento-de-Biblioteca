package br.ufpb.poo.biblioteca.controle;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.poo.biblioteca.entidade.Aluno;
import br.ufpb.poo.biblioteca.entidade.Pessoa;
import br.ufpb.poo.biblioteca.excecao.AlunoInexistenteException;
import br.ufpb.poo.biblioteca.excecao.AlunoJaCadastradoException;
import br.ufpb.poo.biblioteca.excecao.CampoInvalidoException;


public class GerenteAluno {
	
	private List<Aluno> alunos = new ArrayList<Aluno>(); 

	public void addAluno(Aluno aluno){
		validarAluno(aluno);
		alunos.add(aluno);
	}

	private void validarAluno(Aluno aluno) {
		if(aluno.getMatricula() == 0){
			throw new CampoInvalidoException("Aluno sem matricula!!!");
		}
		if(alunoJaCadastrado(aluno)){
			throw new AlunoJaCadastradoException("Aluno ja cadastrado!!!");
		}
		if(aluno.getNome() == null){
			throw new CampoInvalidoException("Aluno sem nome!!!");
		}
		if(aluno.cpf().getCpf() == null){
			throw new CampoInvalidoException("Aluno sem CPF!!!");
		}
		if(cpfJaCadastrado(aluno)){
			throw new CampoInvalidoException("CPF ja cadastrado!!!");
		}
		if(aluno.getCurso() == null){
			throw new CampoInvalidoException("Aluno sem curso!!!");
		}
		if(!aluno.cpf().validarCpf()){
			throw new CampoInvalidoException("CPF invalido!!!");
		}
	}
	
	private boolean cpfJaCadastrado(Aluno aluno) {
		boolean cadastrado = false;
		for(Pessoa a: alunos){
			if(a.cpf().getCpf().equals(aluno.cpf().getCpf())){
				cadastrado = true;
			}
		}
		return cadastrado;
	}
	
	public boolean alunoJaCadastrado(Pessoa aluno){
		boolean existe = false;
		for(Pessoa a: alunos){
			if(a.equals(aluno)){
				existe = true;
			}
		}
		return existe;
	}
	public int quantidadeDeAlunos() {
		return alunos.size();
	}
	public void removerAluno(Aluno aluno) {
		if(quantidadeDeAlunos() == 0){
			throw new AlunoInexistenteException("Não existe aluno para remover!!!");
		}
		if(!exiteAluno(aluno)){
			throw new AlunoInexistenteException("Aluno inexistente!!!");
		}
		alunos.remove(aluno);
	}
	public Aluno getAluno(int pos) {
		return alunos.get(pos);
	}
	
	public boolean exiteAluno(Aluno aluno){
		boolean existe = false;
		for(Aluno a :alunos){
			if(a.equals(aluno)){
				existe = true;
			}
		}
		return existe;
	}

	//TODO Só testa o primeiro aluno?
	//Não deve ser público
	//Remover esse método
	public boolean validarCpfDeAluno() {
		return getAluno(0).cpf().validarCpf();
	}

}
