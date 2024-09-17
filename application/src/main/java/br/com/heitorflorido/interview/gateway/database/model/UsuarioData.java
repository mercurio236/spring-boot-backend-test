package br.com.heitorflorido.interview.gateway.database.model;

import br.com.heitorflorido.interview.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("seg_usuario")
public class UsuarioData {

    @Id
    @Column("id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column("nm_usuario")
    String nome;
    @Column("ds_cidade")
    String cidade;
    @Column("cd_uf")
    String uf;

    public static UsuarioData toUsuarioData(final Usuario usuario) {

        return UsuarioData.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .build();
    }

    public static Usuario toUsuario(final UsuarioData usuario) {

        return Usuario.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .build();
    }
}
