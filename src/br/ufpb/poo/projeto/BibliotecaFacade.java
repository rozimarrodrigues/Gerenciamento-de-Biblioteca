package br.ufpb.poo.projeto;

public class BibliotecaFacade {

	private GerenteAluno gerenteAluno = new GerenteAluno();
	private GerenteFuncionario gerenteFuncionario = new GerenteFuncionario();
	private GerenteProfessor gerenteProfessor = new GerenteProfessor();
	
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

	public boolean validarCpfDeFuncionario(int pos) {
		return gerenteFuncionario.validarCpfDeFuncionario(pos);
	}

	public void removeFuncionario(Funcionario funcionario) {
		gerenteFuncionario.removeFuncionario(funcionario);
	}

	public Funcionario getFuncionario(int pos) {
		return gerenteFuncionario.getFuncionario(pos);
	}

	public boolean validarCpfDeAluno() {
		return gerenteAluno.validarCpfDeAluno();
	}

	public void adicionaProfessor(Professor professor) {
		gerenteProfessor.addProfessor(professor);		
	}

	public Professor getProfessor(int pos) {
		return gerenteProfessor.getProfessor(pos);
	}
}
