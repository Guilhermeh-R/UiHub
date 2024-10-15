package com.uihub.uihub.controllers;

import com.uihub.uihub.models.Produto;
import com.uihub.uihub.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> addProduto(@RequestBody Produto produto) {
        try {
            Produto savedProduto = produtoService.saveProduto(produto);
            return ResponseEntity.ok(savedProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        return produtoService.getProdutoById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduto(@PathVariable Integer id, @RequestBody Produto produtoDetails) {
        try {
            Produto updatedProduto = produtoService.updateProduto(id, produtoDetails);
            return ResponseEntity.ok(updatedProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/estoque")
    public ResponseEntity<?> updateEstoque(@PathVariable Integer id, @RequestBody Integer novoEstoque) {
        try {
            Produto updatedProduto = produtoService.updateEstoque(id, novoEstoque);
            return ResponseEntity.ok(updatedProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
}
