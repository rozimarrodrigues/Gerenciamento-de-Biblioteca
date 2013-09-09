package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class ProfessorJaCadastradoException extends RuntimeException {
	
	public ProfessorJaCadastradoException(String msg){
		super(msg);
	}
}
