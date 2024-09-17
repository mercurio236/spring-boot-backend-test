package br.com.heitorflorido.interview.usecase;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.UsuarioGatway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    @Autowired
    private UsuarioGatway usuarioGatway;

    public Mono<Void> execute(Long id){
        return usuarioGatway.deletarUsuario(id);
    }
}
