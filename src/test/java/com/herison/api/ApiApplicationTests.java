package com.herison.api;




	import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.herison.api.builder.CategoriaBuilder;
import com.herison.api.builder.ProdutoBuilder;
import com.herison.api.domain.Categoria;
import com.herison.api.domain.Produto;

	class ApiApplicationTests {

	// void contextLoads() {
	// }

	@Test
	public void testarCategoriaProduto(){
	CategoriaBuilder categoriaBuilder = CategoriaBuilder.umaCategoria();
	Categoria cat1 = categoriaBuilder.comNome("Moda").build();
	Categoria cat2 = categoriaBuilder.comNome("Eletrodomestico").build();


	ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
	Produto p1 = produtoBuilder.comNome("Jeans").build();
	Produto p2 = produtoBuilder.comNome("Geladeira").build();


	cat1.getProdutos().addAll(Arrays.asList(p1));
	cat2.getProdutos().addAll(Arrays.asList(p2));

	p1.getCategorias().addAll(Arrays.asList(cat1));
	p2.getCategorias().addAll(Arrays.asList(cat2));

	String saidaEsperada = "Jeans";
	String saidaAtual = null;

	saidaAtual = cat1.getProdutos().get(1).getNome();

	assertEquals(saidaEsperada, saidaAtual);

	}

	@Test
	public void testarCategoriaList(){
	CategoriaBuilder categoriaBuilder = CategoriaBuilder.umaCategoria();
	Categoria cat1 = categoriaBuilder.comNome("Moda").build();
	Categoria cat2 = categoriaBuilder.comNome("Eletrodomestico").build();


	ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
	Produto p1 = produtoBuilder.comNome("Jeans").build();
	Produto p2 = produtoBuilder.comNome("Geladeira").build();


	cat1.getProdutos().addAll(Arrays.asList(p1));
	cat2.getProdutos().addAll(Arrays.asList(p2));

	p1.getCategorias().addAll(Arrays.asList(cat1));
	p2.getCategorias().addAll(Arrays.asList(cat2));

	List<Produto> saidaEsperada = cat1.getProdutos();
	List<Produto> saidaAtual = null;

	saidaAtual = cat2.getProdutos();

	assertEquals(saidaEsperada, saidaAtual);
	}

}
