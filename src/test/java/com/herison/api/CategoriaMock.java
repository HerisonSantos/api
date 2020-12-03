package com.herison.api;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.herison.api.builder.ProdutoBuilder;
import com.herison.api.domain.Produto;
import com.herison.api.services.CategoriaService;
import com.herison.api.services.ProdutoService;

public class CategoriaMock {
	
	private ProdutoService service ;
	private CategoriaService serviceCategoria;

	
	@Test
	public void testarGet(){
		
		 ProdutoBuilder produtoBuilder = ProdutoBuilder.umProduto();
		 
		 List<Produto> listProd1=new ArrayList<>();
		 Produto p = produtoBuilder.comNome("Perifericos").comPreco(0.0).comID(null).build();
	
		 service = Mockito.mock(ProdutoService.class);
	Mockito.when(service.findAll()).thenReturn(Arrays.asList(p));
	
	Double saidaEsperada = 0.0;
	Double saidaAtual = service.TotalCategoria();
	
	
	
	
	assertEquals(saidaEsperada, saidaAtual);

	}
}
