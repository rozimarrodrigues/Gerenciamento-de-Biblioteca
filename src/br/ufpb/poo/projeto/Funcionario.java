package br.ufpb.poo.projeto;

public class Funcionario extends Pessoa {

	private int matricula;
	private String funcao;
	
	public int getMatricula(){
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getFuncao(){
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
