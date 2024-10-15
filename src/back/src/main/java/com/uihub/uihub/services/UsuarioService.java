package com.uihub.uihub.services;

import com.uihub.uihub.models.Usuario;
import com.uihub.uihub.models.Loja;
import com.uihub.uihub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LojaService lojaService;

    public List<Usuario> findAll() {
        // Retorna todos os usuários do banco de dados.
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        // Busca um usuário pelo seu ID.
        return usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        // Define a data de registro se não estiver definida
        if (usuario.getDataDeRegistro() == null) {
            usuario.setDataDeRegistro(LocalDateTime.now());
        }

        // Salva o usuário no banco de dados
        Usuario savedUsuario = usuarioRepository.save(usuario);

        // Checa se o usuário já tem uma loja associada
        Optional<Loja> existingLoja = lojaService.findByUsuarioId(savedUsuario.getIdUsuario());
        if (!existingLoja.isPresent()) {
            // Cria e configura uma nova loja com dados padrão
            Loja loja = new Loja();
            loja.setUsuario(savedUsuario);
            loja.setNome("Loja do " + savedUsuario.getNome());
            loja.setBanner("https://marketplace.canva.com/EAFb9QOJg5g/1/0/1600w/canva-banner-para-loja-online-frete-gr%C3%A1tis-mercado-shops-m%C3%A9dio-paTGOKamJ9A.jpg"); // Caminho para um banner padrão
            loja.setCorMenu("#FFFFFF"); // Cor padrão do menu
            loja.setCorTextoMenu("#000000"); // Cor padrão do texto do menu
            loja.setCorFundo("#FFFFFF"); // Cor padrão do fundo
            lojaService.save(loja);
        }

        return savedUsuario;
    }

    // Deleta um usuário pelo ID
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
