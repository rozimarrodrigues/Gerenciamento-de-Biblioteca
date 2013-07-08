package br.ufpb.poo.projeto;

import java.util.ArrayList;
import java.util.List;

public class GerenteFuncionario {

	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public void addFuncionario(Funcionario funcionario) {
		if(funcionarioJaCadastrado(funcionario)){
			throw new FuncionarioJaCadastradoException("Funcionario ja cadastrado!!!");
		}
		funcionarios.add(funcionario);
	}

	public int quantidadeDefuncionarios() {
		return funcionarios.size();
	}

}
