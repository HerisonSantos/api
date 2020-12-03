package com.herison.api;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.herison.api.builder.ProdutoBuilder;
import com.herison.api.domain.Produto;
import com.herison.api.services.CategoriaService;
import com.herison.api.services.ProdutoService;

public class CategoriaMock {
	
	private ProdutoService service;
	private CategoriaService Catservice;
	
	@Test
	public void testarGet(){
	ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
	List<Produto> listProd1=new ArrayList<>();
	listProd1.add(produtoBuilder.comNome("Perifericos").comPreco(20.0).build());

	service = Mockito.mock(ProdutoService.class);
	Mockito.when(service.findAll()).thenReturn(listProd1);

	Double saidaEsperada = 2.0;
	Double saidaAtual = null;
	
	saidaAtual = Catservice.TotalCategoria();
	assertEquals(saidaEsperada, saidaAtual);

	}
}
