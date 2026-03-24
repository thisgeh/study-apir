package br.com.fiap.study_apir.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping()
    public ResponseEntity<String> create(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
        //return "Produto criado";
    }

    //codigo 200 => encontrado com sucesso
    @GetMapping
    public ResponseEntity<String> findById(){
        return ResponseEntity.status(HttpStatus.OK).body("Morango");
        //return "Morango";
    }

    @PutMapping
    public ResponseEntity<String> update(){
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado");
        //return "Produto atualizado";
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluido");
        //return "Produto excluido";
    }
}
