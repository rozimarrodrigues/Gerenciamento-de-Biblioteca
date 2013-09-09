package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class ProfessorInexistenteException extends RuntimeException {
	
	public ProfessorInexistenteException(String msg){
		super(msg);
	}
}
