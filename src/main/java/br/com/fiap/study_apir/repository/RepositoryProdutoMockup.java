package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    private long ID = 0L;

    public RepositoryProdutoMockup() {
        produtos.add(new Produto(ID++, "Kiwi", BigDecimal.valueOf(10.50))); // new operador que instancia(cria) um objeto na memória (em um endereco)

        produtos.add(new Produto(ID++, "Pitaya", BigDecimal.valueOf(15.99))); // produto recebe o endereço do objeto / add -> a lista recebe endereço de
                                             // memoria
    }

    public RepositoryProdutoMockup(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(Long id) { // optional ter ou não o produto
        return produtos.stream() // stream para percorrer a lista completa em memória
                .filter(p -> p.getId().equals(id)) // filter percorre elemento por elemento
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }

    public Produto create(Produto produto) {
        // atribuir o id novo ao produto a ser cadastrado
        produto.setId(ID++);
        produtos.add(produto);
        return produto;
    }

    public boolean update(Long id, Produto produto){
        Optional<Produto> optProduto = this.findById(id);
        if (optProduto.isPresent()) {
            Produto produtoAtual = optProduto.get();
            produtoAtual.setNome(produto.getNome());
            produtoAtual.setValor(produto.getValor());

            return true;
            
        }
        return false;
    }
}