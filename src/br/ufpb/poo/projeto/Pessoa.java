package br.ufpb.poo.projeto;

public class Pessoa {

	private String nome;
	private Cpf cpf;

	public Pessoa() {
		nome = null;
		cpf = new Cpf();
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Cpf cpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf.setCpf(cpf);
	}

}