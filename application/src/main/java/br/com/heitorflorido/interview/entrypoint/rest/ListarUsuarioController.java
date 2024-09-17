package br.com.heitorflorido.interview.entrypoint.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.ListarUsuarioUseCase;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/listar-usuario")
public class ListarUsuarioController {
    
    @Autowired
    private ListarUsuarioUseCase listarUsuarioUseCase;

    @GetMapping
    public List<Usuario> getUser() {
        return listarUsuarioUseCase.execute();
    }
    
}
