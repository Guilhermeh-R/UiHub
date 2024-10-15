package com.uihub.uihub.services;

import com.uihub.uihub.models.Pedido;
import com.uihub.uihub.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    public List<Pedido> findByLojaId(Integer lojaId) {
        return pedidoRepository.findByLojaId(lojaId);
    }

    public Pedido save(Pedido pedido) {
        logger.info("Salvando pedido: {}", pedido);
        return pedidoRepository.save(pedido);
    }

    public void delete(Pedido pedido) {
        logger.info("Deletando pedido: {}", pedido);
        pedidoRepository.delete(pedido);
    }

    public Optional<Pedido> findById(Integer id) {
        logger.info("Buscando pedido por ID: {}", id);
        return pedidoRepository.findById(id);
    }
}
