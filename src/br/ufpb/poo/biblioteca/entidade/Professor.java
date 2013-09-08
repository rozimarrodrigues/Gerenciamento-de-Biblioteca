package br.ufpb.poo.biblioteca.entidade;

public class Professor extends Pessoa {

	private int matricula;
	private String departamento;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getDepartamento(){
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	

}
