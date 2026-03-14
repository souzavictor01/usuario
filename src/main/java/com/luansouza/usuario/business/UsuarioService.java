package com.luansouza.usuario.business;

import com.luansouza.usuario.business.DTO.UsuarioDTO;
import com.luansouza.usuario.business.converter.UsuarioConverter;
import com.luansouza.usuario.infrastructure.entity.Usuario;
import com.luansouza.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

    public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
       return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

    }
}
