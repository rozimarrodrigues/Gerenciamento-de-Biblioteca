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
		if(professor.cpf().getCpf() == null){
			throw new CampoInvalidoException("Professor sem CPF!!!");
		}
		if(!professor.cpf().validarCpf()){
			throw new CampoInvalidoException("CPF invalido!!!");
		}
		if(cpfJaCadastrado(professor)){
			throw new CampoInvalidoException("CPF ja cadastrado!!!");
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
	
	public boolean validarCpfDeProfessor(int pos) {
		return getProfessor(pos).cpf().validarCpf();
	}
	
	private boolean cpfJaCadastrado(Professor professor) {
		boolean cadastrado = false;
		for(Pessoa a: professores){
			if(a.cpf().getCpf().equals(professor.cpf().getCpf())){
				cadastrado = true;
			}
		}
		return cadastrado;
	}

	public void removeProfessor(Professor professor) {
		if(quantidadeDeProfessores() == 0){
			throw new ProfessorInexistenteException("Não existe professor para remover");
		}
		professores.remove(professor);		
	}

	public int quantidadeDeProfessores() {
		return professores.size();
	}
}
