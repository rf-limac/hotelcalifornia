package br.com.hotelCalifornia.infraestruture.model;

import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder


@Table(name = "hotel_california")
public class HotelCaliforniaModel {
    @Id
    @Column(columnDefinition = "UUID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column (name="name")
    private String name;
    @Column (name="local")
    private String local;
    @Column (name="capacidade")
    private int capacidade;
    @Column (name="cnpj")
    private String cnpj;
}
