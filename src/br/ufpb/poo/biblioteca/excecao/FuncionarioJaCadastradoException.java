package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class FuncionarioJaCadastradoException extends RuntimeException {
	public FuncionarioJaCadastradoException(String msg){
		super(msg);
	}
}
