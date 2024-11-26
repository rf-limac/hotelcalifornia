package br.com.hotelCalifornia.infraestruture.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hotelCalifornia.infraestruture.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestruture.repository.HotelCaliforniaRepository;

@Service
public class HotelCalioforniaService {

    @Autowired
    private HotelCaliforniaRepository hotelCaliforniaRepository; 

    public HotelCaliforniaModel salvarHotel(HotelCaliforniaModel hotelCaliforniaModel){
    return hotelCaliforniaRepository.save(hotelCaliforniaModel);
    }

    public List<HotelCaliforniaModel> listarHotel(){
        return hotelCaliforniaRepository.findAll();
    }

    public Optional<HotelCaliforniaModel> buscarHotelId(UUID id){
        return hotelCaliforniaRepository.findById(id);
    }

    public HotelCaliforniaModel atualizarHotel(UUID id, HotelCaliforniaModel hotel){
        if(hotelCaliforniaRepository.existsById(id)){
            hotel.setName(hotel.getName());
            hotel.setLocal(hotel.getLocal());
            hotel.setCapacidade(hotel.getCapacidade());
            hotel.setCnpj(hotel.getCnpj());
            return hotelCaliforniaRepository.save(hotel);
    } return null;

    }

    public boolean apagarHotel(UUID id){
        if(hotelCaliforniaRepository.existsById(id)){
            hotelCaliforniaRepository.deleteById(id);
        return true;
        }
    return false;   
    }

}

