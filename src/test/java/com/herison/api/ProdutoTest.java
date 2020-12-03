package com.herison.api;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.herison.api.builder.CategoriaBuilder;
import com.herison.api.builder.ProdutoBuilder;
import com.herison.api.domain.Categoria;
import com.herison.api.domain.Produto;
import com.herison.api.services.ProdutoService;

public class ProdutoTest {

	 ProdutoService service = new ProdutoService();
	
	 @Test
	public void testarCategoriaProduto(){
	CategoriaBuilder categoriaBuilder = CategoriaBuilder.umaCategoria();
	Categoria cat1 = categoriaBuilder.comNome("Moda").build();
	Categoria cat2 = categoriaBuilder.comNome("Eletrodomestico").build();


	ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
	Produto p2 = produtoBuilder.comNome("Geladeira").comPreco(0.0).build();


	cat1.setProdutos(Arrays.asList(p2));
	

	p2.setCategorias(Arrays.asList(cat1));

	Double saidaEsperada = 20.0;
	Double saidaAtual = null;

	saidaAtual = service.TotalCategoria();

	assertEquals(saidaEsperada, saidaAtual);

	}

	@Test
	public void testarCategoriaList(){
	CategoriaBuilder categoriaBuilder = CategoriaBuilder.umaCategoria();
	Categoria cat1 = categoriaBuilder.comNome("Moda").build();
	Categoria cat2 = categoriaBuilder.comNome("Eletrodomestico").build();


	ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
	Produto p1 = produtoBuilder.comNome("Jeans").comPreco(100.00).build();
	Produto p2 = produtoBuilder.comNome("Geladeira").comPreco(200.0).build();


	cat1.setProdutos(Arrays.asList(p1));
	cat2.setProdutos(Arrays.asList(p2));

	p1.setCategorias(Arrays.asList(cat1));
	p2.setCategorias(Arrays.asList(cat2));

	String saidaEsperada = "Eletrodomestico";
	String saidaAtual = null;

	saidaAtual = p2.getCategorias().get(0).getNome();

	assertEquals(saidaEsperada, saidaAtual);
	}

		}
