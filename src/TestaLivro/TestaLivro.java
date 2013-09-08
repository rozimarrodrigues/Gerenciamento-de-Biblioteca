package TestaLivro;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.poo.biblioteca.controle.GerenteLivro;
import br.ufpb.poo.biblioteca.entidade.Aluno;
import br.ufpb.poo.biblioteca.entidade.Livro;
import br.ufpb.poo.biblioteca.excecao.LivroInexistenteException;
import br.ufpb.poo.biblioteca.excecao.LivroJaExisteException;
import br.ufpb.poo.biblioteca.facade.BibliotecaFacade;


public class TestaLivro {
	
	@Test
	public void testaCadastroLivro() {
		
		GerenteLivro livraria = new GerenteLivro();
		Livro liv1 = new Livro("Java7", 10);
		
			try {
				livraria.inserirLivro(liv1);
				Livro liv = livraria.pesquisaLivro(10);
				assertEquals("Java7", liv.getNomeLivro());
				
			} catch (LivroJaExisteException e) {
				fail("nao deve lanca esta excecao");
			}catch (LivroInexistenteException e){
				fail("nao deve lancar essa excecao!");
			}
				
	}
}
