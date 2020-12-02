package com.herison.api.builder;


	import com.fasterxml.jackson.annotation.JsonBackReference;
	import com.herison.api.domain.Categoria;
	import com.herison.api.domain.Produto;
	import org.yaml.snakeyaml.events.Event;

	import javax.persistence.*;
	import java.util.ArrayList;
	import java.util.List;

	public class ProdutoBuilder {

	private static final long SERIAL_VERSION_UID_DEFAULT = 1L;
	private static final Integer ID_DEFAULT = 1;
	private static final String NOME_DEFAULT = "Computador";
	private static final Double PRECO_DEFAULT = 1.400;
	private static final List<Categoria> CATEGORIAS_DEFAULT = null;

	private static final long serialVersionUID = SERIAL_VERSION_UID_DEFAULT;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nome = NOME_DEFAULT;
	private Double preco = PRECO_DEFAULT;
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = CATEGORIAS_DEFAULT;

	private ProdutoBuilder() {
	}

	public static ProdutoBuilder umProduto(){
	return new ProdutoBuilder();
	}

	public ProdutoBuilder comID(Integer id){
	this.id = id;
	return this;
	}

	public ProdutoBuilder comNome(String nome){
	this.nome = nome;
	return this;
	}

	public ProdutoBuilder comPreco(Double preco){
	this.preco = preco;
	return this;
	}

	public ProdutoBuilder comCategoria(List<Categoria> categorias){
	this.categorias = categorias;
	return this;
	}


	public ProdutoBuilder mas(){
	return new ProdutoBuilder().comID(id).comNome(nome).comPreco(preco).comCategoria(categorias);
	}

	public Produto build(){
	Produto produto = new Produto();
	produto.setId(id);
	produto.setNome(nome);
	produto.setPreco(preco);
	produto.setCategorias(categorias);
	return produto;
	}


	}

