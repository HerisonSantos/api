package com.herison.api.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herison.api.domain.Categoria;
import com.herison.api.domain.Produto;
import com.herison.api.services.CategoriaService;
import com.herison.api.services.ProdutoService;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@Autowired
	private ProdutoService serviceProduto;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Categoria> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		 obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj,@PathVariable Integer id, @RequestParam(value = "produto",defaultValue ="0") Integer idProduto){
			
		obj.setId(id);
			if(idProduto!=0) {
			Produto produto = serviceProduto.find(idProduto);
			produto.getCategorias().addAll((Arrays.asList(obj)));
			produto= serviceProduto.update(produto);
			obj.getProdutos().addAll((Arrays.asList(produto)));
			}
			obj =service.update(obj);
			return ResponseEntity.noContent().build();
	}
}
