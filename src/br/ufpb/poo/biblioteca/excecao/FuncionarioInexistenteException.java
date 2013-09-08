package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class FuncionarioInexistenteException extends RuntimeException  {
	public FuncionarioInexistenteException(String msg){
		super(msg);
	}
}
