package br.ufpb.poo.projeto;

public class Livro {
	
	private String nome;
	private String autor;
	private String curso;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", autor=" + autor + ", curso=" + curso
				+ "]";
	}
}
