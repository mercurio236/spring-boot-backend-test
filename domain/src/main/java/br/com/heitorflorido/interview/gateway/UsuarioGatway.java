package br.com.heitorflorido.interview.gateway;

import java.util.List;

import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Mono;


public interface UsuarioGatway {
    Mono<Usuario> registrarUser(Usuario user);
    Mono<Void> deletarUsuario(Long id);
    Mono<Usuario> consultarUsuario(Long id);
    List<Usuario> listarUsuario();
    Mono<Long> atualizarUsuario(Long id, Usuario usuario);
}
