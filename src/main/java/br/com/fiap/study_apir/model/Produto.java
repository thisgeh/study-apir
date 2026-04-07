package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.Data;
// import lombok.Getter;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;

// com lombok não precisa criar getter e setter
@Data
// @Getter
// @Setter
// @RequiredArgsConstructor
public class Produto {
    public Produto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;

    }
    
    private Long id;
    private String nome;
    private BigDecimal valor; // para valores monetários
}
