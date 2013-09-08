package br.ufpb.poo.biblioteca.entidade;

public class Funcionario extends Pessoa {
	private int matricula;
	public String funcao;

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String getFuncao) {
		this.funcao = getFuncao;
	}

}