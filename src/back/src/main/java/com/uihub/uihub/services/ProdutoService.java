package com.uihub.uihub.services;

import com.uihub.uihub.models.Produto;
import com.uihub.uihub.repositories.LojaRepository;
import com.uihub.uihub.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public Produto saveProduto(Produto produto) {
        if (produto.getIdLojaTransient() == null || !lojaRepository.existsById(produto.getIdLojaTransient())) {
            throw new IllegalArgumentException("Loja não pode ser nula e deve ter um ID válido");
        }
        produto.setLoja(lojaRepository.findById(produto.getIdLojaTransient()).orElseThrow(() -> new RuntimeException("Loja não encontrada com o ID: " + produto.getIdLojaTransient())));
        return produtoRepository.save(produto);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto updateProduto(Integer id, Produto produtoDetails) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
        if (produtoDetails.getIdLojaTransient() == null || !lojaRepository.existsById(produtoDetails.getIdLojaTransient())) {
            throw new IllegalArgumentException("Loja atualizada não pode ser nula e deve ter um ID válido");
        }
        produto.setLoja(lojaRepository.findById(produtoDetails.getIdLojaTransient()).orElseThrow(() -> new RuntimeException("Loja não encontrada com o ID: " + produtoDetails.getIdLojaTransient())));
        produto.setNome(produtoDetails.getNome());
        produto.setDescricao(produtoDetails.getDescricao());
        produto.setPreco(produtoDetails.getPreco());
        produto.setFoto(produtoDetails.getFoto());
        produto.setDataCriacao(produtoDetails.getDataCriacao());
        produto.setDataAtualizacao(produtoDetails.getDataAtualizacao());
        produto.setEstoque(produtoDetails.getEstoque()); // Atualizar estoque
        return produtoRepository.save(produto);
    }

    public Produto updateEstoque(Integer id, Integer novoEstoque) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
        produto.setEstoque(novoEstoque);
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Integer id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
        produtoRepository.delete(produto);
    }
}
