package br.ufpb.poo.projeto;

@SuppressWarnings("serial")
public class CampoInvalidoException extends RuntimeException {
	CampoInvalidoException(String msg){
		super(msg);
	}
}
