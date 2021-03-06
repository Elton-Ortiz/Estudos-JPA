package br.com.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;

public class ProdutoDao {

	
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
	this.em = em;
	}
	
	public void cadastrarProduto (Produto produto) {
		em.persist(produto);
	}
	
	public void atualizarProduto(Produto produto) {
		produto = em.merge(produto);
	}
	
	public void deletarProduto(Produto produto) {
		produto = em.merge(produto);
		em.remove(produto);
	}
	
	public List<Produto> selecionarPorCategoria (Categoria categoria) {
		
		String JPQL = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
		return em.createQuery(JPQL, Produto.class).setParameter(1, categoria.getNome()).getResultList();
				}
}
