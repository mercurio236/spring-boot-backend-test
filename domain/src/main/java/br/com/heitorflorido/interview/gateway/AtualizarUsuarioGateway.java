package br.com.heitorflorido.interview.gateway;

import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Mono;

public interface AtualizarUsuarioGateway {
    Mono<Long> atualizarUsuario(Long id, Usuario usuario);
}
