package br.com.heitorflorido.interview.usecase;


import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.UsuarioGatway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@Named
@RequiredArgsConstructor
public class CadastroUsuarioUseCase {

    @Autowired
    private UsuarioGatway usuarioGatway;

    public Mono<Usuario> execute(Usuario user) {
        return usuarioGatway.registrarUser(user);
    }
}
