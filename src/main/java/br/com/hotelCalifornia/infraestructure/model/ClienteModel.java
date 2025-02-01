package br.com.hotelCalifornia.infraestructure.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class ClienteModel {

    @Id
    @Column(columnDefinition = "UUID")
    @NotNull
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String telefone;

    @Column
    private LocalDate dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelCaliforniaModel hotel;

    public ClienteModel() {
    }
}

