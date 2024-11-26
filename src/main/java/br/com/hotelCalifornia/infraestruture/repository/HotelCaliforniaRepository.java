package br.com.hotelCalifornia.infraestruture.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hotelCalifornia.infraestruture.model.HotelCaliforniaModel;

public interface HotelCaliforniaRepository  extends JpaRepository<HotelCaliforniaModel, UUID>{

    @Query(value= "SELECT * FROM HOTEL_CALIFORNIA WHERE CNPJ = :CNPJ", nativeQuery = true)
    HotelCaliforniaModel findByCnpj(@Param("CNPJ") String cnpj);
    
    @Query(value= "SELECT * FROM HOTEL_CALIFORNIA WHERE CAPACIDADE = :CAPACIDADE", nativeQuery = true)
    HotelCaliforniaModel findByCnpj(@Param("CAPACIDADE") int CAPACIDADE)

}

