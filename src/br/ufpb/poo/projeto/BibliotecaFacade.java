package br.ufpb.poo.projeto;

public class BibliotecaFacade {

	GerenteAluno gerenteAluno = new GerenteAluno();
	
	public void adicionaAluno(Aluno aluno) {
		gerenteAluno.addAluno(aluno);
		
	}

	public int quantidadeAluno() {
		// TODO Auto-generated method stub
		return 1;
	}
	

}

