package com.generation.LojaoDosGames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.LojaoDosGames.Model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel>findAllByCategoriaContainingIgnoreCase(String categoria);

}
