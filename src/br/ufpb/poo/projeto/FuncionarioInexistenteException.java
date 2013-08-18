package br.ufpb.poo.projeto;

@SuppressWarnings("serial")
public class FuncionarioInexistenteException extends RuntimeException  {
	public FuncionarioInexistenteException(String msg){
		super(msg);
	}
}
