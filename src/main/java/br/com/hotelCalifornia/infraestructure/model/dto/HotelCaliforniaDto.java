package br.com.hotelCalifornia.infraestructure.model.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class HotelCaliforniaDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UUID id;

    @NotNull(message = "Nome do Hotel obrigatório")
    private String name;

    @NotNull(message = "Local do Hotel obrigatório")
    private String local;
  
    @NotNull(message = "CNPJ do Hotel obrigatório")
    private String cnpj;



}
