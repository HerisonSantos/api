package com.herison.api.builder;


	import com.fasterxml.jackson.annotation.JsonManagedReference;
	import com.herison.api.domain.Categoria;
	import com.herison.api.domain.Produto;

	import javax.persistence.*;
	import java.util.ArrayList;
	import java.util.List;

	@Entity
	public class CategoriaBuilder {

	private static final long SERIAL_VERSION_DEFAULT = 1L;
	private static final Integer ID_DEFAULT = 1;
	private static final String NOME_DEFAULT = "Informática";
	private static final List<Produto> PRODUTOS_DEFAULT = null;


	private static final long serialVersionUID = SERIAL_VERSION_DEFAULT;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nome = NOME_DEFAULT;

	@JsonManagedReference
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = PRODUTOS_DEFAULT;

	private CategoriaBuilder(){}

	public static CategoriaBuilder umaCategoria() {
	return new CategoriaBuilder();
	}

	public CategoriaBuilder comID(Integer id){
	this.id = id;
	return this;
	}

	public CategoriaBuilder comNome(String nome){
	this.nome = nome;
	return this;
	}

	public CategoriaBuilder comProdutos(List<Produto> produtos){
	this.produtos = produtos;
	return this;
	}

	public CategoriaBuilder mas(){
	return new CategoriaBuilder().comID(id).comNome(nome).comProdutos(produtos);
	}

	public Categoria build(){
	Categoria categoria = new Categoria();
	categoria.setId(id);
	categoria.setNome(nome);
	categoria.setProdutos(produtos);
	return categoria;
	}


	}