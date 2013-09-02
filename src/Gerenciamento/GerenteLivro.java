package Gerenciamento;

import java.util.ArrayList;
import java.util.List;
import Exception.LivroInexistenteException;
import Exception.LivroJaExisteException;
import br.ufpb.poo.projeto.Livro;

public class GerenteLivro {
	
	List<Livro> livros = new ArrayList<>();
		
		public void inserirLivro(Livro p) throws LivroJaExisteException{
			for( Livro liv:this.livros){
				if(this.existeLivro(p)){
					throw new LivroJaExisteException("Livro ja cadastrado");
				}
			}
			this.livros.add((Livro)p);
		}
	
		private boolean existeLivro(Livro aux) {
			for (Livro liv: this.livros){
				if (liv.getCodigoLivro() == aux.getCodigoLivro()){
					return true;
				}
			}
			return false;
		}
		public Livro pesquisaLivro(int codigoLivro) throws LivroInexistenteException{
			for (int i = 0; i < this.livros.size(); i++){
				if (this.livros.get(i).getNomeLivro().equals(codigoLivro)) {
					return (Livro)this.livros.get(i);
				}
			}
			throw new LivroInexistenteException("Nao existe livro com o codigo: "+codigoLivro);
		}
		
		
		public void atualizarLivro(Livro liv1, Livro liv2) {
			for (int i = 0; i < this.livros.size(); i++) {
				if (this.livros.get(i).equals(liv1)) {
					this.livros.set(i, (Livro)liv2);
				}
			}

		}
		
		public void removeLivro(Livro liv) {
			this.livros.remove((Livro)liv);
		}
		
		public List<Livro> getLivrosCadastrados() {
			return this.livros;
		}

	
	
}