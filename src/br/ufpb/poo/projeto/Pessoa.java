package br.ufpb.poo.projeto;

public class Pessoa {

	private String nome;
	private Cpf cpf;

	public Pessoa() {
		super();
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Cpf getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf.setCpf(cpf);
	}

}