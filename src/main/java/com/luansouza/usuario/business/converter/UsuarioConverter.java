package com.luansouza.usuario.business.converter;

import com.luansouza.usuario.business.DTO.EnderecoDTO;
import com.luansouza.usuario.business.DTO.TelefoneDTO;
import com.luansouza.usuario.business.DTO.UsuarioDTO;
import com.luansouza.usuario.infrastructure.entity.Endereco;
import com.luansouza.usuario.infrastructure.entity.Telefone;
import com.luansouza.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usurioDTO) {
        return Usuario.builder()
                .nome(usurioDTO.getNome())
                .sobrenome(usurioDTO.getSobrenome())
                .email(usurioDTO.getEmail())
                .senha(usurioDTO.getSenha())
                .endereco(paraListaEndereco(usurioDTO.getEndereco()))
                .telefone(paraListaTelefone(usurioDTO.getTelefone()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();

        //Outa forma de fazer a mesma coisa:

//        List<Endereco> endereco = new ArrayList<>();
//        for(EnderecoDTO enderecoDTO : enderecoDTOS) {
//            endereco.add(paraEndereco(enderecoDTO));
//        }
//        return endereco;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    /// /////////////////////////////////////////////////////////////////////////////////

    public UsuarioDTO paraUsuarioDTO(Usuario usurioDTO) {
        return UsuarioDTO.builder()
                .nome(usurioDTO.getNome())
                .sobrenome(usurioDTO.getSobrenome())
                .email(usurioDTO.getEmail())
                .senha(usurioDTO.getSenha())
                .endereco(paraListaEnderecoDTO(usurioDTO.getEndereco()))
                .telefone(paraListaTelefoneDTO(usurioDTO.getTelefone()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEnderecoDTO).toList();

        //Outa forma de fazer a mesma coisa:

//        List<Endereco> endereco = new ArrayList<>();
//        for(EnderecoDTO enderecoDTO : enderecoDTOS) {
//            endereco.add(paraEndereco(enderecoDTO));
//        }
//        return endereco;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) {
        return EnderecoDTO.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO) {
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }
}
