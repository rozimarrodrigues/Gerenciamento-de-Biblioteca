package Gerenciamento;

import java.util.ArrayList;
import java.util.List;
import Exception.LivroInexistenteException;
import Exception.LivroJaExisteException;
import br.ufpb.poo.projeto.Livro;

public class GerenteLivro {
	
	List<Livro> livros = new ArrayList<>();
		
	public void addLivro(String nomeLivro, int codigoLivro) throws LivroJaExisteException{
		if(this.existeLivro(codigoLivro)){
			throw new LivroJaExisteException("Livro ja cadastrado!");
			}
			else{
				this.livros.add(new Livro(nomeLivro, codigoLivro));
			}
		}
		
		private boolean existeLivro(int codigoLivro) {
			for (Livro liv: this.livros){
				if (liv.getCodigoLivro() == codigoLivro){
					return true;
				}
			}
			return false;
		}
		public Livro pesquisaLivro(int codigoLivro) throws LivroInexistenteException{
			for (Livro li: this.livros){
				if (li.getCodigoLivro() == codigoLivro){
					return li;
				}
			}
			throw new LivroInexistenteException("Nao existe livro com o codigo: "+codigoLivro);
		}
		
		
		public List<Livro> getLivrosCadastrados() {
			return this.livros;
		}

	
	
}