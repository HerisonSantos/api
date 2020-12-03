package com.herison.api;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import com.herison.api.builder.ProdutoBuilder;
import com.herison.api.domain.Produto;
import com.herison.api.services.CategoriaService;
import com.herison.api.services.ProdutoService;
import com.sun.xml.bind.v2.model.impl.ArrayInfoImpl;

public class CategoriaMock {
	
	@Test
	public void testarGet(){
		
		 ProdutoService service = new ProdutoService();
		 
	
		 ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		 
		 List<Produto> listProd1=new ArrayList<>();
		 Produto p = produtoBuilder.comNome("Perifericos").comPreco(20.0).comID(null).build();
	//listProd1.add(produtoBuilder1.comNome("informatica").comPreco(15.0).comID(null).build());

	service = Mockito.mock(ProdutoService.class);
	Mockito.when(service.findAll()).thenReturn(Arrays.asList(p));
	ProdutoService service1 = new ProdutoService();
	 
	Double saidaEsperada = 2.0;
	Double saidaAtual = null;
	
	saidaAtual = service.TotalCategoria(listProd1);
	assertEquals(saidaEsperada, saidaAtual);

	}
}
