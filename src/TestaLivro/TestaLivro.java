package TestaLivro;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.poo.projeto.Aluno;
import br.ufpb.poo.projeto.BibliotecaFacade;
import br.ufpb.poo.projeto.Livro;
import Exception.LivroInexistenteException;
import Exception.LivroJaExisteException;
import Gerenciamento.GerenteLivro;


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
