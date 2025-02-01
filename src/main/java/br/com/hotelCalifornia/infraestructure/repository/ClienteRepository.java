package br.com.hotelCalifornia.infraestructure.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hotelCalifornia.infraestructure.model.ClienteModel;



    @Repository
    public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    
        @Query(value = "SELECT * FROM CLIENTE WHERE CPF = :CPF", nativeQuery = true)
        ClienteModel findByCpf(@Param("CPF") String cpf);
    
        @Query(value = "SELECT * FROM CLIENTE WHERE HOTEL_ID = :ID", nativeQuery = true)
        List<ClienteModel> listClientsByHotel(@Param("ID") UUID id);

}


