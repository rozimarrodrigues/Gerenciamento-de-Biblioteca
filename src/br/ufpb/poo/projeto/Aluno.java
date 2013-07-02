package br.ufpb.poo.projeto;

public class Aluno {
	private String nome;
	private String matricula;

	public String getMatricula(){
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getNome(){
		return nome;
	}
}
