package br.ufpb.poo.biblioteca.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.poo.biblioteca.entidade.Aluno;
import br.ufpb.poo.biblioteca.entidade.Funcionario;
import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.entidade.Professor;
import br.ufpb.poo.biblioteca.excecao.AlunoInexistenteException;
import br.ufpb.poo.biblioteca.excecao.AlunoJaCadastradoException;
import br.ufpb.poo.biblioteca.excecao.CampoInvalidoException;
import br.ufpb.poo.biblioteca.excecao.FuncionarioInexistenteException;
import br.ufpb.poo.biblioteca.excecao.FuncionarioJaCadastradoException;
import br.ufpb.poo.biblioteca.excecao.ProfessorInexistenteException;
import br.ufpb.poo.biblioteca.excecao.ProfessorJaCadastradoException;
import br.ufpb.poo.biblioteca.facade.BibliotecaFacade;


public class BibliotecaFacadeTest {

	private BibliotecaFacade biblioteca;
	private static final String CPF = "047.389.784-97"; 

	@Before
	public void iniciar(){
		biblioteca = new BibliotecaFacade(); 
	}

	@Test
	public void adicionarAluno() {
		Aluno aluno = criarAlunoPadrao();
		biblioteca.adicionarAluno(aluno);

		Aluno aux = biblioteca.getAluno(0);
		assertEquals(aluno, aux);
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

		Aluno aux = biblioteca.getAluno(1);
		assertEquals("Espera-se que o segundo aluno seja o alunoAuxiliar",
				aluno, aux);
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
		aluno.setCpf(CPF);//Mesmo CPF do alunoPadrao
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
		assertTrue(biblioteca.validarCpfDeAluno());
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

	@Test 
	public void adicionarFuncionario(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);

		Funcionario aux = biblioteca.getFuncionario(0);
		assertEquals(funcionario, aux);
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

		Funcionario aux = biblioteca.getFuncionario(1);
		assertEquals("Espera-se que o segundo funcionario seja o funcionarioAuxiliar",
				funcionario, aux);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemNome(){
		Funcionario funcionario = criarFuncionarioAuxiliar();
		funcionario.setNome(null);
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemMatricula(){
		Funcionario funcionario = criarFuncionarioAuxiliar();
		funcionario.setMatricula(0);
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemFuncao(){
		Funcionario funcionario = criarFuncionarioPadrao();
		funcionario.setFuncao(null);
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioSemCpf(){
		Funcionario funcionario = criarFuncionarioPadrao();
		funcionario.setCpf(null);
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test // Validar CPF do tipo "000.000.000-00"
	public void adicionarFuncionarioComCpfValido(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		assertTrue(biblioteca.validarCpfDeFuncionario(0));
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarFuncionarioComCpfInvalido(){
		Funcionario funcionario = criarFuncionarioPadrao();
		funcionario.setCpf("12345");
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test(expected = CampoInvalidoException.class) 
	public void adicionarFuncionarioComCpfJaCadastrado(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		funcionario = criarFuncionarioAuxiliar();
		funcionario.setCpf(CPF);//Mesmo CPF do funcionarioPadrao
		biblioteca.adicionaFuncionario(funcionario);
	}

	@Test
	public void removerFuncionario(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		biblioteca.removeFuncionario(funcionario);
		assertEquals("Esperasse que não tenha funcionario",
				0,biblioteca.quantidadeFuncionarios());
	}

	@Test(expected = FuncionarioInexistenteException.class)
	public void removerFuncionarioNovamente(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		biblioteca.removeFuncionario(funcionario);
		biblioteca.removeFuncionario(funcionario);
	}

	@Test 
	public void removerFucionarioDiferente(){
		Funcionario funcionario1 = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario1);
		Funcionario funcionario2 = criarFuncionarioAuxiliar();
		biblioteca.adicionaFuncionario(funcionario2);
		biblioteca.removeFuncionario(funcionario1);
		biblioteca.removeFuncionario(funcionario2);
		assertEquals(0, biblioteca.quantidadeFuncionarios());
	}

	@Test(expected = FuncionarioInexistenteException.class)
	public void removerFuncionarioInexistente(){
		Funcionario funcionario = criarFuncionarioPadrao();
		biblioteca.adicionaFuncionario(funcionario);
		funcionario = criarFuncionarioAuxiliar();
		biblioteca.removeFuncionario(funcionario);
	}

	@Test
	public void adicionarProfessor(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);

		Professor aux = biblioteca.getProfessor(0);  
		assertEquals(professor, aux);
	}

	@Test(expected = ProfessorJaCadastradoException.class)
	public void adicionarProfessorNovamente(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		biblioteca.adicionaProfessor(professor);
	}

	@Test
	public void adicionarProfessorDiferente(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		professor = criarProfessorAuxiliar();
		biblioteca.adicionaProfessor(professor);

		Professor aux = biblioteca.getProfessor(1);
		assertEquals(professor, aux);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarProfessorSemNome(){
		Professor professor = criarProfessorPadrao();
		professor.setNome(null);
		biblioteca.adicionaProfessor(professor);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarProfessorSemMatricula(){
		Professor professor = criarProfessorPadrao();
		professor.setMatricula(0);
		biblioteca.adicionaProfessor(professor);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarProfessorSemDepartamento(){
		Professor professor = criarProfessorPadrao();
		professor.setDepartamento(null);
		biblioteca.adicionaProfessor(professor);
	}

	@Test(expected = CampoInvalidoException.class)
	public void adicionarProfessorSemCpf(){
		Professor professor = criarProfessorPadrao();
		professor.setCpf(null);
		biblioteca.adicionaProfessor(professor);
	}

	@Test // Validar CPF do tipo "000.000.000-00"
	public void adicionarProfessorComCpfValido(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		assertTrue(biblioteca.validarCpfDeProfessor(0));
	}
	
	@Test(expected = CampoInvalidoException.class)
	public void adicionarProfessorComCpfInvalido(){
		Professor professor = criarProfessorPadrao();
		professor.setCpf("12345");
		biblioteca.adicionaProfessor(professor);
	}
	
	@Test(expected = CampoInvalidoException.class) 
	public void adicionarProfessorComCpfJaCadastrado(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		professor = criarProfessorAuxiliar();
		professor.setCpf(CPF);//Mesmo CPF do ProfessorPadrao
		biblioteca.adicionaProfessor(professor);
	}
	
	@Test
	public void removerProfessor(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		biblioteca.removerProfessor(professor);
		assertEquals("Esperasse que não tenha professor",
				0,biblioteca.quantidadeProfessores());
	}
	
	@Test(expected = ProfessorInexistenteException.class)
	public void removerProfessorNovamente(){
		Professor professor = criarProfessorPadrao();
		biblioteca.adicionaProfessor(professor);
		biblioteca.removerProfessor(professor);
		biblioteca.removerProfessor(professor);
	}
	
	@Test
	public void adicionarLivro(){
		Livro livro = new Livro();
		biblioteca.adicionarLivro(livro);
		
		Livro aux = biblioteca.getLivro(0);
		assertEquals(livro, aux);
	}

	private Aluno criarAlunoPadrao() {
		Aluno aluno = new Aluno();
		aluno.setNome("Rozimar");
		aluno.setMatricula(80921004);
		aluno.setCurso("Computação");
		aluno.setCpf(CPF);
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
		funcionario.setCpf(CPF);
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

	private Professor criarProfessorPadrao(){
		Professor professor;
		professor = new Professor();
		professor.setNome("Leopoldo");
		professor.setMatricula(80912123);
		professor.setCpf(CPF);
		professor.setDepartamento("DCE");
		return professor;
	}

	private Professor criarProfessorAuxiliar(){
		Professor professor;
		professor = new Professor();
		professor.setNome("Luiz");
		professor.setMatricula(80921005);
		professor.setCpf("123.345.456-45");
		professor.setDepartamento("Educação");
		return professor;
	}
}