package com.herison.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.herison.api.builder.CategoriaBuilder;
import com.herison.api.domain.Categoria;
import com.herison.api.resources.CategoriaResource;
import com.herison.api.services.CategoriaService;

public class CategoriaMock {
	
	@Test
	public void testarGet(){
	CategoriaResource categoriaResource = new CategoriaResource();

	CategoriaBuilder categoriaBuilder = CategoriaBuilder.umaCategoria();
	Categoria cat1 = categoriaBuilder.comNome("Perifericos").build();


	CategoriaService csmock = Mockito.mock(CategoriaService.class);
	Mockito.when(csmock.find(1)).thenReturn(cat1);

	Categoria saidaEsperada = cat1;
	ResponseEntity<?> saidaAtual = null;

	saidaAtual = categoriaResource.find(1);
	assertEquals(saidaEsperada, saidaAtual);

	}
}
