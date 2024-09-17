package br.com.heitorflorido.interview.entrypoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.AtualizarUsuarioUseCase;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class AtualizarController {

    @Autowired
    private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    @PutMapping("/atualizar/{id}")
    public Mono<Long> atualizar(@PathVariable Long id, @RequestBody Usuario usuario ){
        return atualizarUsuarioUseCase.execute(id, usuario);
    }
    
}
