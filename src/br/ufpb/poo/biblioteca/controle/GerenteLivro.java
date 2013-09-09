package br.ufpb.poo.biblioteca.controle;

import java.util.ArrayList;
import java.util.List;
import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.excecao.LivroInexistenteException;
import br.ufpb.poo.biblioteca.excecao.LivroJaCadastradoException;

public class GerenteLivro {
	
	List<Livro> livros = new ArrayList<Livro>();
		
		public void inserirLivro(Livro p) throws LivroJaCadastradoException{
			for( Livro liv:this.livros){
				if(this.existeLivro(p)){
					throw new LivroJaCadastradoException("Livro ja cadastrado");
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