package br.com.heitorflorido.interview.gateway.database;

import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.AtualizarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Named
@RequiredArgsConstructor
public class AtualizarUsuarioDatabaseGateway implements AtualizarUsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Mono<Long> atualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).flatMap(usuarioData -> {
            BeanUtils.copyProperties(usuario, usuarioData, "id");

            return usuarioRepository.save(usuarioData).map(UsuarioData::getId);
        })
                .switchIfEmpty(Mono.error(new RuntimeException("Usuário não foi encontrado.")));

    }

}
