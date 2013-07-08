package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteAluno {
	
	private List<Aluno> alunos = new ArrayList<Aluno>(); 

	public void addAluno(Aluno aluno){
		if(aluno.getMatricula() == 0){
			System.out.println("aluno sem matricula");
			throw new CampoInvalidoException("Aluno sem matricula!!!");
		}
		if(alunoJaCadastrado(aluno)){
			System.out.println("aluno já cadastrado");
			throw new AlunoJaCadastradoException("Aluno ja cadastrado!!!");
		}
		if(aluno.getNome() == null){
			System.out.println("aluno sem nome");
			throw new CampoInvalidoException("Aluno sem nome!!!");
		}
		if(aluno.cpf().getCpf() == null){
			System.out.println("aluno sem cpf");
			throw new CampoInvalidoException("Aluno sem CPF!!!");
		}
		if(cpfJaCadastrado(aluno)){
			System.out.println("cpf ja cadastrado");
			throw new CampoInvalidoException("CPF ja cadastrado!!!");
		}
		if(aluno.getCurso() == null){
			System.out.println("aluno sem curso");
			throw new CampoInvalidoException("Aluno sem curso!!!");
		}
		alunos.add(aluno);
		
	}
	private boolean cpfJaCadastrado(Aluno aluno) {
		boolean cadastrado = false;
		for(Pessoa a: alunos){
			if(a.cpf().getCpf().equals(aluno.cpf().getCpf())){
				cadastrado = true;
			}
		}
		return cadastrado;
	}
	public boolean alunoJaCadastrado(Pessoa aluno){
		boolean existe = false;
		for(Pessoa a: alunos){
			if(a.equals(aluno)){
				existe = true;
			}
		}
		return existe;
	}
	public int quantidadeDeAlunos() {
		return alunos.size();
	}
	public void removerAluno(Pessoa aluno) {
		if(quantidadeDeAlunos() == 0){
			throw new AlunoInexistenteException("Não existe aluno para remover!!!");
		}
		alunos.remove(aluno);
	}
	public Pessoa getAluno(int pos) {
		return alunos.get(pos);
	}

}
