package br.com.heitorflorido.interview.entrypoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.CadastroUsuarioUseCase;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroUsuarioUseCase cadastroUsuarioUseCase;

    @PostMapping
    public Mono<Usuario> registerUser(@RequestBody Usuario request) {
        return cadastroUsuarioUseCase.execute(request);
    }

}
