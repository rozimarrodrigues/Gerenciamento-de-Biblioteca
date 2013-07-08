package br.ufpb.poo.projeto;

public class BibliotecaFacade {

	private GerenteAluno gerenteAluno = new GerenteAluno();
	private GerenteFuncionario gerenteFuncionario = new GerenteFuncionario();
	
	public void adicionarAluno(Aluno aluno) {
		gerenteAluno.addAluno(aluno);
		
	}

	public int quantidadeAlunos() {
		return gerenteAluno.quantidadeDeAlunos();
	}

	public void removeAluno(Aluno aluno) {
		gerenteAluno.removerAluno(aluno);
		
	}

	public Pessoa getAluno(int pos) {
		return gerenteAluno.getAluno(pos);
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		gerenteFuncionario.addFuncionario(funcionario);
	}

	public int quantidadeFuncionarios() {
		return gerenteFuncionario.quantidadeDefuncionarios();
	}
	

}

