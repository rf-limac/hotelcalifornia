package br.com.hotelCalifornia.infraestructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;

public interface HotelCaliforniaRepository  extends JpaRepository<HotelCaliforniaModel, UUID>{

    @Query(value= "SELECT * FROM HOTEL_CALIFORNIA WHERE CNPJ = :CNPJ", nativeQuery = true)
    HotelCaliforniaModel findByCnpj(@Param("CNPJ") String cnpj);
    
    @Query(value= "SELECT * FROM HOTEL_CALIFORNIA WHERE CAPACIDADE = :LOCAL", nativeQuery = true)
    HotelCaliforniaModel findByLocal(@Param("LOCAL") String LOCAL);

}

