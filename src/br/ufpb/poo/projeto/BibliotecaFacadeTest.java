package br.ufpb.poo.projeto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		aluno = criarAlunoAuxiliar();
		biblioteca.adicionaAluno(aluno);
		assertEquals(2,biblioteca.quantidadeAlunos());
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemMatricula(){
		Aluno aluno = new Aluno();
		biblioteca.adicionaAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemCpf(){
		Aluno aluno = criarAlunoPadrao();
		aluno.setCpf(null);
		biblioteca.adicionaAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoComCpfJaCadastrado(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		aluno = criarAlunoAuxiliar();
		aluno.setCpf("047.389.784-97");//Mesmo CPF do alunoPadrao
		biblioteca.adicionaAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemNome(){
		Aluno aluno = criarAlunoAuxiliar();
		aluno.setNome(null);
		biblioteca.adicionaAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemCurso(){
		Aluno aluno = criarAlunoAuxiliar();
		aluno.setCurso(null);
		biblioteca.adicionaAluno(aluno);
	}

	@Test // Validar CPF do tipo "000.000.000-00"
	public void adicionarAlunoComCpfValido(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		assertTrue(biblioteca.getAluno(0).cpf().validarCpf());
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoComCpfInvalido(){
		Aluno aluno = criarAlunoPadrao();
		aluno.setCpf("12345");
		biblioteca.adicionaAluno(aluno);
	}
	
	@Test
	public void removerAluno(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		biblioteca.removeAluno(aluno);
		assertEquals("Esperasse que não tenha aluno",
				0,biblioteca.quantidadeAlunos());
	}

	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoNovamente(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno);
		biblioteca.removeAluno(aluno);
		biblioteca.removeAluno(aluno);
	}
	
	@Test
	public void removerAlunoDiferente(){
		Aluno aluno1 = criarAlunoPadrao();
		biblioteca.adicionaAluno(aluno1);
		Aluno aluno2 = criarAlunoAuxiliar();
		biblioteca.adicionaAluno(aluno2);
		biblioteca.removeAluno(aluno1);
		biblioteca.removeAluno(aluno2);
		assertEquals(0, biblioteca.quantidadeAlunos());
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
		aluno.setCpf("047.389.784-97");
		return aluno;
	}
	
	private Aluno criarAlunoAuxiliar() {
		Aluno aluno;
		aluno = new Aluno();
		aluno.setNome("Rair");
		aluno.setMatricula(80911005);
		aluno.setCurso("Computação");
		aluno.setCpf("057.398.874-79");
		return aluno;
	}
}