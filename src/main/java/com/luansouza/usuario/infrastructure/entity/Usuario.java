package com.luansouza.usuario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@Builder

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "sobrenome", length = 10)
    private String sobrenome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> endereco;
    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }


    // public Usuario(String nome, String email, String senha) {
    // this.nome = nome;
    // this.email = email;
    // this.senha = senha;
    // }

    // public String getNome() {
    // return nome;
    // }

    // public String setNome(String nome) {
    // this.nome = nome;
    // return this.nome;
    // }

//    public String getSobrenome() {
//        return sobrenome;
//    }
//
//    public String setSobrenome(String sobrenome) {
//        this.sobrenome = sobrenome;
//        return this.sobrenome;
//    }
    // public String getEmail() {
    // return email;
    // }

    // public String setEmail() {
    // return this.email;
    // }

    // public String getSenha() {
    // return senha;
    // }

    // public String setSenha() {
    // return this.senha;

    // }

}
