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

	public Aluno getAluno(int pos) {
		return gerenteAluno.getAluno(pos);
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		gerenteFuncionario.addFuncionario(funcionario);
	}

	public int quantidadeFuncionarios() {
		return gerenteFuncionario.quantidadeDefuncionarios();
	}

	public boolean validarCpf(int pos) {
		boolean valido = false;
		valido = gerenteFuncionario.getFuncionario(0).cpf().validarCpf();
		return valido;
	}

	public void removeFuncionario(Funcionario funcionario) {
		gerenteFuncionario.removeFuncionario(funcionario);
	}

	public Funcionario getFuncionario(int pos) {
		return gerenteFuncionario.getFuncionario(pos);
	}
}
