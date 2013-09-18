package br.ufpb.poo.biblioteca.controle;
import java.util.ArrayList;
import java.util.List;

import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.excecao.LivroInexistenteException;
import br.ufpb.poo.biblioteca.excecao.LivroJaCadastradoException;

public class GerenteLivro {
	
	List<Livro> livros;
	
	public GerenteLivro(){
		livros = new ArrayList<Livro>();
	}
	
	public void addLivro(Livro livro){
		
		if(livroJaCadastrado(livro)){
			throw new LivroJaCadastradoException("Livro ja cadastrado!");
		}
		
		livros.add(livro);
	}
	
	public boolean livroJaCadastrado(Livro livro){
		boolean existe = false;
		for(Livro l: livros){
			if(l.equals(livro)){
				existe = true;
			}
		}
		return existe;
	}
	
	public int quantidadeDeLivros() {
		return livros.size();
	}
	
	public void removerLivro(Livro livro) {
		
		if(quantidadeDeLivros() == 0){
			throw new LivroInexistenteException("Não existe livro para remover!!!");
		}
		if(!exiteLivro(livro)){
			throw new LivroInexistenteException("Livro inexistente!!!");
		}
		livros.remove(livro);
	}
	
	public Livro getLivro(int pos) {
		return livros.get(pos);
	}

	public boolean exiteLivro(Livro livro){
		boolean existe = false;
		for(Livro l :livros){
			if(l.equals(livro)){
				existe = true;
			}
		}
		return existe;
	}
}
