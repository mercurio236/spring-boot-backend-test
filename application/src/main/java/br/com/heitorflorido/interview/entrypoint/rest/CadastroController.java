package br.com.heitorflorido.interview.entrypoint.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.CadastroUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cadastro")
public class CadastroController {

 
    private final CadastroUsuarioUseCase cadastroUsuarioUseCase;

    @PostMapping
    public Mono<Usuario> registerUser(@RequestBody Usuario request) {
        return cadastroUsuarioUseCase.execute(request);
    }

}
