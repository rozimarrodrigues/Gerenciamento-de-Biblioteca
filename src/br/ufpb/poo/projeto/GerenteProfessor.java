package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteProfessor {
	
	private List<Professor> professores = new ArrayList<Professor>(); 

	public void addProfessor(Professor professor) {
		professores.add(professor);
	}

}
