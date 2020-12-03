package com.herison.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.herison.api.domain.Categoria;
import com.herison.api.domain.Produto;
import com.herison.api.repositories.ProdutoRepository;
import com.herison.api.services.exeptions.DataIntegrityExeption;
import com.herison.api.services.exeptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+id+", Tipo"+ Produto.class.getName()));
		
	}

	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public List<Produto> findAll() {
		List<Produto> obj = repo.findAll();
		return obj;
	}
	public void delete(Integer id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExeption("Não é possivel excluir uma categoria que tenha produtos");
		}
				
	}
	public Produto update (Produto obj) {
		find(obj.getId());
		return repo.save(obj);
				
	}

}
