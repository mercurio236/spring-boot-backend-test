package br.com.heitorflorido.interview.entrypoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heitorflorido.interview.usecase.DeletarUsuarioUseCase;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class DeletarController {
    
    @Autowired
    private DeletarUsuarioUseCase deletarUsuarioUseCase;

    @DeleteMapping("/delete/usuario/{id}")
    public Mono<Void> deletar(@PathVariable Long id){
        return deletarUsuarioUseCase.execute(id);
    }
}
