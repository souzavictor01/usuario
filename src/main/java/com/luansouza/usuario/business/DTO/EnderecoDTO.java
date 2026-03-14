package com.luansouza.usuario.business.DTO;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EnderecoDTO {

    private String rua;

    private long numero;

    private String cidade;

    private String estado;

    private String cep;

    private String complemento;
}
