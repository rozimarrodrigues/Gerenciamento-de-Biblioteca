package br.ufpb.poo.biblioteca.excecao;

@SuppressWarnings("serial")
public class CampoInvalidoException extends RuntimeException {
	public CampoInvalidoException(String msg){
		super(msg);
	}
}
