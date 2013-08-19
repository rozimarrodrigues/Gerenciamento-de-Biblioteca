package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteProfessor {
	
	private List<Professor> professores = new ArrayList<Professor>(); 

	public void addProfessor(Professor professor) {
		if(professorJaCadastrado(professor)){
			throw new ProfessorJaCadastradoException("Professor ja cadastrado!!!");
		}
		professores.add(professor);
	}

	public Professor getProfessor(int pos){
		return professores.get(pos);
	}
	
	public boolean professorJaCadastrado(Pessoa professor){
		boolean existe = false;
		for(Pessoa a: professores){
			if(a.equals(professor)){
				existe = true;
			}
		}
		return existe;
	}

}
