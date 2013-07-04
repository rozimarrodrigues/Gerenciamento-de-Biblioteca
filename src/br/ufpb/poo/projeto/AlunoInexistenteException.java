package br.ufpb.poo.projeto;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends RuntimeException {
	public AlunoInexistenteException(String msg){
		super(msg);
	}
}
