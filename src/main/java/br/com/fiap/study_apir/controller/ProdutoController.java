package br.com.fiap.study_apir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.ProdutoRepository;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("/api/${api.version}/produtos")
public class ProdutoController {

    private ProdutoRepository repository;

    @PostMapping()
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {

        // Optional<Produto> optProduto = mockup.findById(id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // map pega o produto e atribuir para a variável
    // if (optProduto.isPresent()) {
    // // return ResponseEntity.status(HttpStatus.OK).body(produto);
    // return ResponseEntity.ok(optProduto.get());
    // } else {
    // return ResponseEntity.notFound().build();
    // }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<String> update(@PathVariable Long id,
    //         @RequestBody Produto produto) {

    //     Optional<Produto> optProduto = repository.findById(id);
    //     if(optProduto.isPresent()){
    //         produto.setId(id);
    //         repository.save(produto)
    //     }
    //     if (mockup.update(id, produto)) {

    //         return ResponseEntity.ok("Produto atualizado");
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id, @RequestBody Produto produto) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
        /*if (mockup.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }*/

    }

}