package br.com.hotelCalifornia.infraestructure.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hotelCalifornia.infraestructure.Converter.ClienteConverter;
import br.com.hotelCalifornia.infraestructure.model.ClienteModel;
import br.com.hotelCalifornia.infraestructure.repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


    @Slf4j
    @Service
    @RequiredArgsConstructor
     public class ClienteService {

        @Autowired
    private final ClienteRepository clienteRepository;

    @SuppressWarnings("unused")
    private final ClienteConverter clienteConverter;

    @Transactional
    public ClienteModel create(ClienteModel clienteModel){
        log.info("Criando...");
        return clienteRepository.save(clienteModel);
    }

    @Transactional
    public Optional<ClienteModel> findByID (UUID id){
        return  clienteRepository.findById(id);
    }

    @Transactional
    public List<ClienteModel> listClient() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Optional<ClienteModel> findByCpf (String cpf) {
        return  Optional.ofNullable(clienteRepository.findByCpf(cpf));
    }

    @Transactional
    public List<ClienteModel> listByHotel(UUID hotelID){
        return clienteRepository.listClientsByHotel(hotelID);
    }

    @Transactional
    public ResponseEntity<?> delete(UUID id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().body("Cliente deletado com sucesso");
        }).orElse(ResponseEntity.notFound().build());
    }
}
