package com.uihub.uihub.controllers;

import com.uihub.uihub.models.Loja;
import com.uihub.uihub.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> getLojaByUsuarioId(@PathVariable Integer usuarioId) {
        return lojaService.findByUsuarioId(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> updateLojaByUsuarioId(@PathVariable Integer usuarioId, @RequestBody Loja loja) {
        return lojaService.findByUsuarioId(usuarioId)
                .map(existingLoja -> {
                    updateExistingLoja(existingLoja, loja);
                    lojaService.save(existingLoja);
                    return ResponseEntity.ok(existingLoja);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    private void updateExistingLoja(Loja existingLoja, Loja newLoja) {
        System.out.println("Atualizando dados da loja para o usuário ID: " + existingLoja.getUsuarioId());
        existingLoja.setNome(newLoja.getNome());
        existingLoja.setBanner(newLoja.getBanner());
        existingLoja.setCorMenu(newLoja.getCorMenu());
        existingLoja.setCorTextoMenu(newLoja.getCorTextoMenu());
        existingLoja.setCorFundo(newLoja.getCorFundo());
        existingLoja.setVisitantes(newLoja.getVisitantes());  // Adicionando a atualização de visitantes
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> deleteLojaByUsuarioId(@PathVariable Integer usuarioId) {
        return lojaService.findByUsuarioId(usuarioId)
                .map(loja -> {
                    lojaService.delete(loja);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
