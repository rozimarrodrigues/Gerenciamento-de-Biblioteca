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
		biblioteca.adicionarAluno(aluno);
		assertEquals(1,biblioteca.quantidadeAlunos());
	}

	@Test(expected = AlunoJaCadastradoException.class)
	public void adicionarAlunoNovamente(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		biblioteca.adicionarAluno(aluno);
	}

	@Test
	public void adicionarAlunoDiferente() {
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		aluno = criarAlunoAuxiliar();
		biblioteca.adicionarAluno(aluno);
		assertEquals(2,biblioteca.quantidadeAlunos());
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemMatricula(){
		Aluno aluno = new Aluno();
		biblioteca.adicionarAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemCpf(){
		Aluno aluno = criarAlunoPadrao();
		aluno.setCpf(null);
		biblioteca.adicionarAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoComCpfJaCadastrado(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		aluno = criarAlunoAuxiliar();
		aluno.setCpf("047.389.784-97");//Mesmo CPF do alunoPadrao
		biblioteca.adicionarAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemNome(){
		Aluno aluno = criarAlunoAuxiliar();
		aluno.setNome(null);
		biblioteca.adicionarAluno(aluno);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoSemCurso(){
		Aluno aluno = criarAlunoAuxiliar();
		aluno.setCurso(null);
		biblioteca.adicionarAluno(aluno);
	}

	@Test // Validar CPF do tipo "000.000.000-00"
	public void adicionarAlunoComCpfValido(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		assertTrue(biblioteca.getAluno(0).cpf().validarCpf());
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarAlunoComCpfInvalido(){
		Aluno aluno = criarAlunoPadrao();
		aluno.setCpf("12345");
		biblioteca.adicionarAluno(aluno);
	}
	
	@Test
	public void removerAluno(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		biblioteca.removeAluno(aluno);
		assertEquals("Esperasse que não tenha aluno",
				0,biblioteca.quantidadeAlunos());
	}

	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoNovamente(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		biblioteca.removeAluno(aluno);
		biblioteca.removeAluno(aluno);
	}
	
	@Test
	public void removerAlunoDiferente(){
		Aluno aluno1 = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno1);
		Aluno aluno2 = criarAlunoAuxiliar();
		biblioteca.adicionarAluno(aluno2);
		biblioteca.removeAluno(aluno1);
		biblioteca.removeAluno(aluno2);
		assertEquals(0, biblioteca.quantidadeAlunos());
	}
	
	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoInexstente(){
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);
		aluno = criarAlunoAuxiliar();
		biblioteca.removeAluno(aluno);
	}
	
	@Test // GerenteFuncionario - Rozimar Rodrigues
	public void adicionarFuncionario(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		assertEquals(1, biblioteca.quantidadeFuncionarios());
	}
	
	@Test(expected = FuncionarioJaCadastradoException.class)
	public void adicionarFuncionarioNovamente(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		biblioteca.adicionaFuncionario(funcionario);
	}
	
	@Test
	public void adicionarFuncionarioDiferente(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		funcionario = criarFuncionarioAuxiliar();
		biblioteca.adicionaFuncionario(funcionario);
		assertEquals(2, biblioteca.quantidadeFuncionarios());
	}
	
	//TODO Testes para o GerenteProfessor - Emanuel Rair
	//TODO Testes para o GerenteLivro - Emanuel Rair

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
	
	private Funcionario criarFuncionarioPadrao() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Dayane");
		funcionario.setMatricula(175632);
		funcionario.setFuncao("Bibliotecario");
		funcionario.setCpf("024.769.134-35");
		return funcionario;
	}
	
	private Funcionario criarFuncionarioAuxiliar() {
		Funcionario funcionario;
		funcionario = new Funcionario();
		funcionario.setNome("Marcos");
		funcionario.setMatricula(175632);
		funcionario.setFuncao("Bibliotecario");
		funcionario.setCpf("015.657.367-00");
		return funcionario;
	}
}