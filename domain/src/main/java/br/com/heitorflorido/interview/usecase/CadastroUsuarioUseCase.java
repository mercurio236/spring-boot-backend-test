package br.com.heitorflorido.interview.usecase;


import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.CadastroUsuarioGeteway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@Named
@RequiredArgsConstructor
public class CadastroUsuarioUseCase {

    @Autowired
    private CadastroUsuarioGeteway cadastroUsuarioGeteway;

    public Mono<Usuario> execute(Usuario user) {
        return cadastroUsuarioGeteway.registerUser(user);
    }
}
