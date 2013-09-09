import java.util.ArrayList;
import java.util.List;

import br.ufpb.poo.biblioteca.entidade.Livro;

public class GerenteLivro {
	
	List<Livro> livros;
	
	public GerenteLivro(){
		livros = new ArrayList<Livro>();
	}
	
	public void addLivro(Livro livro){
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
