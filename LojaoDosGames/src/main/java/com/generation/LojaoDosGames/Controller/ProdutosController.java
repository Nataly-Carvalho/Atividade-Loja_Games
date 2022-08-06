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

import com.generation.LojaoDosGames.Model.ProdutosModel;
import com.generation.LojaoDosGames.Repository.ProdutosRepository;

@RestController //Informa para o spring que essa vai ser a classe de controle
@RequestMapping ("/produtos")//Define a URI que a classe vai ser acessada 
@CrossOrigin("*")//Significa que essa classe vai aceitar requisição de qualquer origem
public class ProdutosController {
	
	@Autowired//garante que todos os serviços do repositorio seja acessado pelo controller
	private ProdutosRepository produtosRepository;
		
	@GetMapping // Se a pessoa usar o URI produtos usando o metodo Get
	//vai ser esse metodo que ele vai esta usando
	public ResponseEntity<List<ProdutosModel>> GetAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
				//O response entity significa que vai representar toda a resposta HTTP
				//controlar qualquer coisa que aconteça: código de status, cabeçalhos e corpo
	}
	
	@GetMapping("/{id}")//diferente do find all esse nos precisamos passar um caminho pois so queremos o id
	public ResponseEntity<ProdutosModel> GetById(@PathVariable Long id){
		return  produtosRepository.findById(id) //O pathVariable o valor que entrar no id ela vai ser uma variavel do caminho URI
				.map(resp ->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	//Quando for requisitado o metodo ele vai trazer tudo que esta ligado
	//com aquele id e se o id que for procurado não existir ele da um not found
	}
	
	@GetMapping("/nome/{nome}")//Nossa Api entendo que depois de uma / o ultimo dado é entendi como atributo e da duplicidade
	public ResponseEntity<List<ProdutosModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository
				.findAllByNomeContainingIgnoreCase(nome));
	//foi a requisição que fizemos no nosso ProdutoRepository
	}
	
	@PostMapping//Ele que vai ficar responsavel por postar
	public ResponseEntity<ProdutosModel> getById(@PathVariable Long id) {
		return produtosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	//O @RequestBody ele pega o que esta no corpo da requisição
	}
	
	@PutMapping //Ele vai atualizar o que tem dentro 
	public ResponseEntity<ProdutosModel> putProduto(@RequestBody ProdutosModel produto){
		return ResponseEntity.status(HttpStatus.OK)
				.body(produtosRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")//Ele vai deletar hehe
	public void delete(@PathVariable Long id) {
		produtosRepository.deleteById(id);
	}
	
	

	
}
