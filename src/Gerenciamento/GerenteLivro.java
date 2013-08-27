package Gerenciamento;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.poo.projeto.Livro;

import Exception.LivroInexistenteException;
import Exception.LivroJaCadastradoException;

public class GerenteLivro {
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public void addLivro(Livro livro) throws LivroJaCadastradoException{
		if(livro.getNome() == null){
			throw new LivroJaCadastradoException("Livro ja cadastrado!");
		}
		livros.add(livro);
	}
	
	public boolean livroJaCadastrado(Livro nome){
		boolean existe = false;
		for(Livro l: livros){
			if(l.equals(nome)){
				existe = true;
			}
		}
		return existe;
	}
	
	public int quantidadeDeLivros() {
		return livros.size();
	}
	
	public void removerAluno(Livro livro) {
		if(quantidadeDeLivros() == 0){
			throw new LivroInexistenteException("Não existe Livro para remover!!!");
		}
		if(!existeLivro(livro)){
			throw new LivroInexistenteException("Livro inexistente!!!");
		}
		livros.remove(livro);
	}
	
	public boolean existeLivro(Livro livro){
		boolean existe = false;
		for(Livro l :livros){
			if(l.equals(livro)){
				existe = true;
			}
		}
		return existe;
	}
	
}