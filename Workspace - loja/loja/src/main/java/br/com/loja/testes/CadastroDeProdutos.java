package br.com.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		
		Categoria informatica = new Categoria("Informática");
		Produto notebook = new Produto("Dell","Delux",new BigDecimal(7650), informatica);
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrarCategoria(informatica);
		produtoDao.cadastrarProduto(notebook);
		notebook.setCategoria(informatica);
//		informatica.setNome("Informatica-teste2");
//		categoriaDao.atualizarCategoria(informatica);
//		categoriaDao.deletarCategoria(informatica);
		List<Produto> selecionarPorCategoria = produtoDao.selecionarPorCategoria(informatica);
		selecionarPorCategoria.forEach(item -> System.out.println(item.getName()));
		em.getTransaction().commit();
		em.close();
	}
}
