package br.com.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "produto")   
public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id = 0;
	private String name;
	private String descrição;
	private BigDecimal preco;
	private LocalDate dataDoCadastro = LocalDate.now();
	@ManyToOne
	private Categoria categoria;

	public Produto() {
	}
	
	public Produto( String name, String descrição, BigDecimal preco, Categoria categoria) {
		super();
		this.name = name;
		this.descrição = descrição;
		this.preco = preco;
		this.categoria = categoria;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
