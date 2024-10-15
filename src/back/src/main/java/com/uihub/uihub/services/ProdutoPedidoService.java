package com.uihub.uihub.services;

import com.uihub.uihub.models.ProdutoPedido;
import com.uihub.uihub.repositories.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProdutoPedidoService {

    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    public ProdutoPedido save(ProdutoPedido produtoPedido) {
        return produtoPedidoRepository.save(produtoPedido);
    }

    public void delete(ProdutoPedido produtoPedido) {
        produtoPedidoRepository.delete(produtoPedido);
    }

    public void deleteById(Integer id) {
        produtoPedidoRepository.deleteById(id);
    }

    public Optional<ProdutoPedido> findById(Integer id) {
        return produtoPedidoRepository.findById(id);
    }
}
