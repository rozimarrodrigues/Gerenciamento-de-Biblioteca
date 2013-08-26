package br.ufpb.poo.projeto;

@SuppressWarnings("serial")
public class ProfessorInexistenteException extends RuntimeException {
	
	public ProfessorInexistenteException(String msg){
		super(msg);
	}
}
