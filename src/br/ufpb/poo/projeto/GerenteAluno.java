package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteAluno {
	
	List<Aluno> alunos = new ArrayList<Aluno>(); 

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
		
	}
	public boolean alunoJaCadastrado(Aluno aluno){
		boolean existe = false;
		for(Aluno a: alunos){
			if(a.equals(aluno)){
				existe = true;
			}
		}
		return existe;
	}

}