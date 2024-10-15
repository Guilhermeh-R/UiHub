package com.uihub.uihub.controllers;

import com.uihub.uihub.models.Usuario;
import com.uihub.uihub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Injeção do serviço

    // Obtém todos os usuários
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Obtém um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cria um novo usuário
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    // Atualiza um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id); // Assegura que o ID do usuário está sendo setado corretamente
        Usuario updatedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }
    

    // Deleta um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
