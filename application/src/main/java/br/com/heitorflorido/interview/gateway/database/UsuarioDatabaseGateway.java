package br.com.heitorflorido.interview.gateway.database;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heitorflorido.interview.gateway.UsuarioGatway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioDatabaseGateway implements UsuarioGatway{

    @Autowired
    private UsuarioRepository usuarioRepository; 

    @Override
    public Mono<Usuario> registrarUser(Usuario user) {
          UsuarioData usuarioData = UsuarioData.toUsuarioData(user);

        BeanUtils.copyProperties(user, usuarioData);
        return usuarioRepository.save(usuarioData).map(UsuarioData::toUsuario);
    }

    @Override
    public Mono<Void> deletarUsuario(Long id) {
        var user = usuarioRepository.findById(id).map(UsuarioData::toUsuario);

        if (user != null) {
            return usuarioRepository.deleteById(id);
        } else {
            return Mono.error(new RuntimeException("Usuário não encontrado com ID: " + id));
        }
    }

    @Override
    public Mono<Usuario> consultarUsuario(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioData::toUsuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        Flux<UsuarioData> findUsers = usuarioRepository.findAll();
        List<UsuarioData> response = findUsers.collectList().block();

        return response.stream()
        .map(UsuarioData::toUsuario)
        .collect(Collectors.toList());
    }

    @Override
    public Mono<Long> atualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).flatMap(usuarioData -> {
            BeanUtils.copyProperties(usuario, usuarioData, "id");

            return usuarioRepository.save(usuarioData).map(UsuarioData::getId);
        })
        .switchIfEmpty(Mono.error(new RuntimeException("Usuário não foi encontrado.")));
    }
    
}
