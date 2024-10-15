package com.uihub.uihub.services;

import com.uihub.uihub.models.Loja;
import com.uihub.uihub.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public Optional<Loja> findByUsuarioId(Integer usuarioId) {
        return lojaRepository.findByUsuarioId(usuarioId);
    }

    public Loja save(Loja loja) {
        return lojaRepository.save(loja);
    }

    public void delete(Loja loja) {
        lojaRepository.delete(loja);
    }

    public Optional<Loja> findById(Integer id) {
        return lojaRepository.findById(id);
    }
}
