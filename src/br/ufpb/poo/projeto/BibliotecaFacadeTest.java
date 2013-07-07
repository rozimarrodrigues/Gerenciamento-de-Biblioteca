package br.ufpb.poo.projeto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaFacadeTest {

	private BibliotecaFacade biblioteca;

	@Before
	public void iniciar(){
		biblioteca = new BibliotecaFacade(); 
	}

	@Test // GerenteAluno - Rozimar Rodrigues
	public void adicionarAluno() {
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		assertEquals(1,biblioteca.quantidadeAlunos());
	}

	@Test(expected = AlunoJaCadastradoException.class)
	public void adicionaAlunoNovamente(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		biblioteca.adicionaAluno(aluno);
	}

	@Test
	public void adicionaAlunoDiferente() {
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		aluno = new Aluno();
		aluno.setMatricula(80911005);
		aluno.setCpf("05739887479");
		biblioteca.adicionaAluno(aluno);
		assertEquals(2,biblioteca.quantidadeAlunos());
	}

	@Test
	public void removerAluno(){
		Aluno aluno = new Aluno();
		aluno.setMatricula(80921004);
		aluno.setCpf("04738978497");
		biblioteca.adicionaAluno(aluno);
		biblioteca.removeAluno(aluno);
		assertEquals("Esperasse que não tenha aluno",
				0,biblioteca.quantidadeAlunos());
	}

	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoNovamente(){
		Aluno aluno = new Aluno();
		aluno.setMatricula(80921004);
		aluno.setCpf("04738978497");
		biblioteca.adicionaAluno(aluno);
		biblioteca.removeAluno(aluno);
		biblioteca.removeAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemMatricula(){
		Aluno aluno = new Aluno();
		biblioteca.adicionaAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemCpf(){
		Aluno aluno = new Aluno();
		biblioteca.adicionaAluno(aluno);
	}

	// GerenteProfessor - Emanuel Rair
	/*
	 * TODO testes para o GerenteProfessor
	 */


	private Aluno criarAlunoPadrao() {
		Aluno aluno = new Aluno();
		aluno.setNome("Rozimar");
		aluno.setMatricula(80921004);
		aluno.setCurso("Computação");
		aluno.setCpf("04738978497");
		return aluno;
	}
}