package com.uihub.uihub.controllers;

import com.uihub.uihub.models.Loja;
import com.uihub.uihub.models.Pedido;
import com.uihub.uihub.models.ProdutoPedido;
import com.uihub.uihub.services.LojaService;
import com.uihub.uihub.services.PedidoService;
import com.uihub.uihub.services.ProdutoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private ProdutoPedidoService produtoPedidoService;

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @GetMapping("/loja/{lojaId}")
    public ResponseEntity<List<Pedido>> getPedidosByLojaId(@PathVariable Integer lojaId) {
        List<Pedido> pedidos = pedidoService.findByLojaId(lojaId);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        logger.info("Recebendo pedido: {}", pedido);
        try {
            if (pedido.getLoja() != null && pedido.getLoja().getIdLoja() != null) {
                logger.info("Loja ID: {}", pedido.getLoja().getIdLoja());
                Optional<Loja> lojaOptional = lojaService.findById(pedido.getLoja().getIdLoja());
                if (lojaOptional.isPresent()) {
                    Loja loja = lojaOptional.get();
                    pedido.setLoja(loja);
                    Pedido createdPedido = pedidoService.save(pedido);
                    logger.info("Pedido criado com ID: {}", createdPedido.getIdPedido());
                    for (ProdutoPedido produtoPedido : pedido.getProdutosPedido()) {
                        produtoPedido.setPedido(createdPedido);
                        produtoPedidoService.save(produtoPedido);
                        logger.info("ProdutoPedido criado com ID: {}", produtoPedido.getIdProdutoPedido());
                    }
                    return ResponseEntity.ok(createdPedido);
                } else {
                    logger.error("Loja não encontrada para o ID: {}", pedido.getLoja().getIdLoja());
                    return ResponseEntity.badRequest().body(null);
                }
            } else {
                logger.error("ID da loja não fornecido no pedido");
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            logger.error("Erro ao criar o pedido", e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Optional<Pedido> existingPedido = pedidoService.findById(id);
        return existingPedido.map(p -> {
            p.setNome(pedido.getNome());
            p.setEndereco(pedido.getEndereco());
            p.setCep(pedido.getCep());
            p.setEstado(pedido.getEstado());
            p.setComplemento(pedido.getComplemento());
            p.setMetodoPagamento(pedido.getMetodoPagamento());
            p.setTotalPedido(pedido.getTotalPedido());
            p.setEmail(pedido.getEmail());
            p.setProdutosPedido(pedido.getProdutosPedido());
            pedidoService.save(p);
            for (ProdutoPedido produtoPedido : p.getProdutosPedido()) {
                produtoPedido.setPedido(p);
                produtoPedidoService.save(produtoPedido);
            }
            return ResponseEntity.ok(p);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePedido(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(p -> {
            pedidoService.delete(p);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
