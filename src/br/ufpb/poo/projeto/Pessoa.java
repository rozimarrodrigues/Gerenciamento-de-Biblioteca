package br.ufpb.poo.projeto;

public class Pessoa {

	private String nome;
	private String cpf;

	public Pessoa() {
		super();
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}

}