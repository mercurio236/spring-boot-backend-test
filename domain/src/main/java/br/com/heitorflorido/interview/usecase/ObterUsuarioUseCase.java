package br.com.heitorflorido.interview.usecase;

import br.com.heitorflorido.interview.gateway.UsuarioGatway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

@Named
@RequiredArgsConstructor
public class ObterUsuarioUseCase {

    @Autowired
    private UsuarioGatway usuarioGatway;

    public Mono<Usuario> execute(Long id) {
        return usuarioGatway.consultarUsuario(id);
    }
}
