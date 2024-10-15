package com.uihub.uihub.controllers;

import com.uihub.uihub.models.ProdutoPedido;
import com.uihub.uihub.services.ProdutoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto-pedido")
public class ProdutoPedidoController {

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    @PostMapping
    public ResponseEntity<ProdutoPedido> createProdutoPedido(@RequestBody ProdutoPedido produtoPedido) {
        ProdutoPedido createdProdutoPedido = produtoPedidoService.save(produtoPedido);
        return ResponseEntity.ok(createdProdutoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoPedido> updateProdutoPedido(@PathVariable Integer id, @RequestBody ProdutoPedido produtoPedido) {
        Optional<ProdutoPedido> existingProdutoPedido = produtoPedidoService.findById(id);
        return existingProdutoPedido.map(produto -> {
            produto.setIdProduto(produtoPedido.getIdProduto());
            produto.setQuantidade(produtoPedido.getQuantidade());
            produtoPedidoService.save(produto);
            return ResponseEntity.ok(produto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProdutoPedido(@PathVariable Integer id) {
        Optional<ProdutoPedido> produtoPedido = produtoPedidoService.findById(id);
        return produtoPedido.map(produto -> {
            produtoPedidoService.delete(produto);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
