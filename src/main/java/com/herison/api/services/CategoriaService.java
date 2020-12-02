package com.herison.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.herison.api.domain.Categoria;
import com.herison.api.repositories.CategoriaRepository;
import com.herison.api.services.exeptions.DataIntegrityExeption;
import com.herison.api.services.exeptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id:"+id+", Tipo"+ Categoria.class.getName()));
		
	}

	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public List<Categoria> findAll() {
		List<Categoria> obj = repo.findAll();
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
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
				
	}
	
}
