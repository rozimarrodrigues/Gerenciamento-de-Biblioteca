package br.ufpb.poo.biblioteca.facade;

import br.ufpb.poo.biblioteca.controle.GerenteAluno;
import br.ufpb.poo.biblioteca.controle.GerenteFuncionario;
import br.ufpb.poo.biblioteca.controle.GerenteLivro;
import br.ufpb.poo.biblioteca.controle.GerenteProfessor;
import br.ufpb.poo.biblioteca.entidade.Aluno;
import br.ufpb.poo.biblioteca.entidade.Funcionario;
import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.entidade.Professor;

public class BibliotecaFacade {

	private GerenteAluno gerenteAluno = new GerenteAluno();
	private GerenteFuncionario gerenteFuncionario = new GerenteFuncionario();
	private GerenteProfessor gerenteProfessor = new GerenteProfessor();
	private GerenteLivro gerenteLivro = new GerenteLivro(); 
	
	public void adicionarAluno(Aluno aluno) {
		gerenteAluno.addAluno(aluno);
	}

	public int quantidadeAlunos() {
		return gerenteAluno.quantidadeDeAlunos();
	}

	public void removeAluno(Aluno aluno) {
		gerenteAluno.removerAluno(aluno);
		
	}

	public Aluno getAluno(int pos) {
		return gerenteAluno.getAluno(pos);
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		gerenteFuncionario.addFuncionario(funcionario);
	}

	public int quantidadeFuncionarios() {
		return gerenteFuncionario.quantidadeDefuncionarios();
	}

	public void removeFuncionario(Funcionario funcionario) {
		gerenteFuncionario.removeFuncionario(funcionario);
	}

	public Funcionario getFuncionario(int pos) {
		return gerenteFuncionario.getFuncionario(pos);
	}

	public void adicionaProfessor(Professor professor) {
		gerenteProfessor.addProfessor(professor);		
	}

	public Professor getProfessor(int pos) {
		return gerenteProfessor.getProfessor(pos);
	}

	public void removerProfessor(Professor professor) {
		gerenteProfessor.removeProfessor(professor);
	}

	public int quantidadeProfessores() {
		return gerenteProfessor.quantidadeDeProfessores();
	}
	
	public void adicionarLivro(Livro livro) {
		gerenteLivro.addLivro(livro);
	}
	
	public int quantidadeLivros() {
		return gerenteLivro.quantidadeDeLivros();
	}

	public void removeLivro(Livro livro) {
		gerenteLivro.removerLivro(livro);
		
	}
	public Livro getLivro(int pos) {
		return gerenteLivro.getLivro(pos);
	}
}
