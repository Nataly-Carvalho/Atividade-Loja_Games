package com.generation.LojaoDosGames.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.LojaoDosGames.Model.CategoriaModel;
import com.generation.LojaoDosGames.Repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
			
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<CategoriaModel>> getByCategoria(@PathVariable String categoria){
		return ResponseEntity
			 .ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase (categoria));
	}
			
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategotia (@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategotia (@RequestBody CategoriaModel categoria){
		return ResponseEntity.ok(categoriaRepository.save(categoria));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
	
	}


