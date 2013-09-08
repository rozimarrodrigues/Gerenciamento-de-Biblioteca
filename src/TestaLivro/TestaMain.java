package TestaLivro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import br.ufpb.poo.biblioteca.controle.GerenteLivro;
import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.excecao.LivroInexistenteException;
import br.ufpb.poo.biblioteca.excecao.LivroJaExisteException;

public class TestaMain {

	public static void main(String[] args) {
		
		GerenteLivro livraria = new GerenteLivro();
		Livro liv1 = new Livro("Java1", 1);
		Livro liv2 = new Livro("Java2", 2);
		Livro liv3 = new Livro("Java3", 3);
			
			try {
				livraria.inserirLivro(liv1);
				livraria.inserirLivro(liv2);
				livraria.inserirLivro(liv3);
				
				livraria.atualizarLivro(liv1, liv3);
				System.out.println(livraria.getLivrosCadastrados());
				
			} catch (LivroJaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
