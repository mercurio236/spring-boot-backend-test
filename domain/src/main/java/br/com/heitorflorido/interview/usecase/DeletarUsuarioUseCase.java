package br.com.heitorflorido.interview.usecase;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.DeletarUsuarioGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Named
@RequiredArgsConstructor
public class DeletarUsuarioUseCase {

    @Autowired
    private DeletarUsuarioGateway deletarUsuarioGateway;

    public Mono<Void> execute(Long id){
        return deletarUsuarioGateway.deletarUsuario(id);
    }
}
