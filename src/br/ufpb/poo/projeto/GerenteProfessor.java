package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteProfessor {
	
	private List<Professor> professores = new ArrayList<Professor>(); 

	public void addProfessor(Professor professor) {
		if(professor.getMatricula() == 0){
			throw new CampoInvalidoException("Professor sem matricula!!!");
		}
		if(professorJaCadastrado(professor)){
			throw new ProfessorJaCadastradoException("Professor ja cadastrado!!!");
		}
		if(professor.getNome() == null){
			throw new CampoInvalidoException("Professor sem nome!!!");
		}
		if(professor.getDepartamento() == null){
			throw new CampoInvalidoException("Professor sem departamento!!!");
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
