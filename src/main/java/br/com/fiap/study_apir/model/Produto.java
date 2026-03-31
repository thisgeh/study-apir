package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
//@Getter
//@Setter
//@RequiredArgsConstructor //cria construtor para todos final
public class Produto {
    private final Long id;
    private final String nome;    
    private final BigDecimal valor; //para valores monetarios

    //construtores somente para atributos obrigatorios (final)   
}
