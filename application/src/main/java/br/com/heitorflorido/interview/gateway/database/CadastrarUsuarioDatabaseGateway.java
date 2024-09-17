package br.com.heitorflorido.interview.gateway.database;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heitorflorido.interview.gateway.CadastroUsuarioGeteway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Mono;

@Service
public class CadastrarUsuarioDatabaseGateway implements CadastroUsuarioGeteway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> registerUser(Usuario user) {

        UsuarioData usuarioData = UsuarioData.toUsuarioData(user);

        BeanUtils.copyProperties(user, usuarioData);
        return usuarioRepository.save(usuarioData).map(UsuarioData::toUsuario);

    }

}
