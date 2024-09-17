package br.com.heitorflorido.interview.usecase;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.heitorflorido.interview.gateway.UsuarioGatway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ListarUsuarioUseCase {
    
    @Autowired
    private UsuarioGatway usuarioGatway;

    public List<Usuario> execute(){
        return usuarioGatway.listarUsuario();
    }
}
