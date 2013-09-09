package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends RuntimeException {
	public AlunoInexistenteException(String msg){
		super(msg);
	}
}
