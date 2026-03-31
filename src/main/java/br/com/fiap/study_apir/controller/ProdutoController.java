package br.com.fiap.study_apir.controller;

import java.util.List;

//import java.util.Optional;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("/api/${api.version}/produtos")
public class ProdutoController {

    private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    @PostMapping()
    public ResponseEntity<String> create(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
       return mockup
       .findById(id)
       .map(ResponseEntity::ok)
       .orElse(ResponseEntity.notFound().build());

    /*Optional<Produto> optProduto = mockup.findById(id);
        if(optProduto.isPresent()){
            //return ResponseEntity.status(HttpStatus.OK).body(produto);
            //return ResponseEntity.ok(produto);
            return ResponseEntity.ok(optProduto.get());
        }
        else{
            //return ResponseEntity.status?(HttpStatus.NOT_FOUND).body(null);
            //return ResponseEntity.notFound().build();
            return ResponseEntity.notFound().build();
        }*/
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(mockup.findAll());
    }

    @PutMapping
    public ResponseEntity<String> update(){
        return ResponseEntity.ok("produto atualizado");
        //return "Produto atualizado";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (mockup.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluido");
        //return "Produto excluido";
    }
}
