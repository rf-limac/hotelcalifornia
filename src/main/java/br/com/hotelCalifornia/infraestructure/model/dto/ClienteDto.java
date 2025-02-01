package br.com.hotelCalifornia.infraestructure.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ClienteDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @NotNull(message = "O NOME DO HOTAL É OBRIGATÓRIO")
    @Size(min = 1, max = 50, message = "O NOME DO HOTEL DEVE CONTER ENTRE 1 ATÉ 50 CARACTERES")
    private String name;

    @NotNull(message = "CPF OBRIGATÓRIO")
    private String cpf;

    @NotNull(message = "A CAPACIDADE É OBRIGATÓRIA")
    private String email;

    private String telefone;

    private String DataNascimento;

}
