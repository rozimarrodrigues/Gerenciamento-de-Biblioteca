package br.ufpb.poo.projeto;

public class BibliotecaFacade {

	private GerenteAluno gerenteAluno = new GerenteAluno();
	
	public void adicionaAluno(Aluno aluno) {
		gerenteAluno.addAluno(aluno);
		
	}

	public int quantidadeAlunos() {
		return gerenteAluno.quantidadeDeAlunos();
	}

	public void removeAluno(Aluno aluno) {
		gerenteAluno.removerAluno(aluno);
		
	}
	

}

