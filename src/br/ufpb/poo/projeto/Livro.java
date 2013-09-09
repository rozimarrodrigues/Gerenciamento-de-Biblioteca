package br.ufpb.poo.projeto;

public class Livro {
	
	private String nomeLivro;
	private int codigoLivro;
	
	public Livro(String nomeLivro, int codigoLivro) {
		this.nomeLivro = nomeLivro;
		this.codigoLivro = codigoLivro;
	}
		
	public int getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	@Override
	public String toString() {
		return "Livro [nomeLivro =" + nomeLivro + ", codigoLivro =" + codigoLivro
				+ "]";
	}
	
	
	
}
