package com.generation.LojaoDosGames.Model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //Indica que a classe vai fazer parte do JPA ouseja vai ser adicionada la no banco de dados
@Table(name = "tb_Produtos")// essa entidade vai ser uma tabela e o nome dela vai ser postagens
public class ProdutosModel {
	
	@Id// ele indica que vai ser um id na nossa base de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Significa que o id vai ser gerado automaticamente e ele é unico e imutavel
	//e tambem é a nossa chave primaria.
	private Long id;
	
	@NotBlank// essa anotação indica que o campo não pode esta vazio e não aceita espaços em branco
	@Size(min = 2, max = 100, message = "O atributo nome tem que ter no minimo 2 carcter e no maximo 100")
	private String nome;
	
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	private int quantidade;
	@ManyToOne// Relaçao Muitos para um 
	@JsonIgnoreProperties("produtos")//Ele diz o que precisa ignorar quando chegar em produtos por exemplo
	private CategoriaModel categoria;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
