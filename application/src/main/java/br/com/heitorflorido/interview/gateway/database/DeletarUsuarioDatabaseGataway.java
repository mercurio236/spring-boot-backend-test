package br.com.heitorflorido.interview.gateway.database;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioDatabaseGataway implements DeletarUsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Mono<Void> deletarUsuario(Long id) {
        var user = usuarioRepository.findById(id).map(UsuarioData::toUsuario);

        if (user != null) {
            return usuarioRepository.deleteById(id);
        } else {
            return Mono.error(new RuntimeException("Usuário não encontrado com ID: " + id));
        }

    }

}
