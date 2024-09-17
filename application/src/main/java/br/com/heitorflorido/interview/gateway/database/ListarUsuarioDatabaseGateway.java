package br.com.heitorflorido.interview.gateway.database;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heitorflorido.interview.gateway.ListarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Flux;

@Service
public class ListarUsuarioDatabaseGateway implements ListarUsuarioGateway {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuario() {
        Flux<UsuarioData> findUsers = usuarioRepository.findAll();
        List<UsuarioData> response = findUsers.collectList().block();

        return response.stream()
        .map(UsuarioData::toUsuario)
        .collect(Collectors.toList());

    }

}
