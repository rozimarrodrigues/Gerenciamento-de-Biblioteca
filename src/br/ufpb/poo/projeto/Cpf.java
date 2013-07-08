package br.ufpb.poo.projeto;

public class Cpf {
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean validarCpf(){
		boolean valido = false;
		try {
			String primeiraParte = cpf.substring(0, 3);
			String s1 = cpf.substring(3, 4);
			String segundaParte = cpf.substring(4, 7);
			String s2 = cpf.substring(7, 8);
			String terceiraParte = cpf.substring(8, 11);
			String s3 = cpf.substring(11, 12);
			String digito = cpf.substring(12, cpf.length());

			if(s1.equals(".") && 
					s2.equals(".") && 
					s3.equals("-") && 
					primeiraParte.length()==3 &&
					segundaParte.length()==3 &&
					terceiraParte.length()==3 &&
					digito.length()==2){
				try {
					Integer.parseInt(primeiraParte);
					Integer.parseInt(segundaParte);
					Integer.parseInt(terceiraParte);
					Integer.parseInt(digito);
					valido = true;
				}catch (NumberFormatException e) {
					valido = false;
				}
			}
		}catch (StringIndexOutOfBoundsException e) {
			valido = false;
		}
		return valido;
	}
}
