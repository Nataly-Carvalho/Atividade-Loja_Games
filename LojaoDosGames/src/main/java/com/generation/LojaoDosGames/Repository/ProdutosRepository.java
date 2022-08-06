package com.generation.LojaoDosGames.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.LojaoDosGames.Model.ProdutosModel;
@Repository//Informa a o JPA que se trata de uma interface de repositorio         
															//Aqui falamos a entidade que estamos 
															//trabalhando e o tipo do id
public interface ProdutosRepository extends JpaRepository <ProdutosModel, Long> {
	public List<ProdutosModel>findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
							//Esse metodo findBy é utilizado para escontar coisas especificas 
	                        //do nosso model no caso estamos fazendo uma busca pelo nome
							//Quando chamado no controller
	public List <ProdutosModel> findByPrecoBetween(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);
}
//O @Param é a correção de um bug que apareceu que quando chamava mais de uma vez o findBy ele so 
//funcionava da primeira vez

//o FindAllBy Nome containig ele busca todas as strings que estiverem na variavel nome
//O IgnoreCase ele não leva em concideração se esta em maiusculo ou minusculo.