package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrarCategoria(Categoria categoria) {
		em.persist(categoria);
		em.flush();
	}
	
	public void atualizarCategoria(Categoria categoria) {
		categoria = em.merge(categoria);
	}
	
	public void deletarCategoria(Categoria categoria) {
		categoria = em.merge(categoria);
		em.remove(categoria);
	}
}
