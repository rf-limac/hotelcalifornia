package br.com.hotelCalifornia.infraestructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.hotelCalifornia.infraestructure.excepitions.UnprocessableEntityException;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestructure.model.dto.HotelCaliforniaDto;
import br.com.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
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

    @Transactional(readOnly = true)
    public HotelCaliforniaDto buscarCnpj (String cnpj){

        try{ HotelCaliforniaModel hotel = Optional.ofNullable(hotelCaliforniaRepository.findByCnpj(cnpj)).orElseThrow(
            () -> new UnprocessableEntityException("CNPJ NÃO LOCALIZADO" + cnpj));
            return toDto(hotel);
        
        } catch(UnprocessableEntityException unp){
            throw new UnprocessableEntityException(unp.getMessage() );
        }
        catch(Exception e){
            throw new UnprocessableEntityException("ERRO - AO BUSCAR DO CNPJ " + e);
        }

}


@Transactional(readOnly = true)
    public HotelCaliforniaDto buscarLLocal (String local){

        try{ HotelCaliforniaModel hotel = Optional.ofNullable(hotelCaliforniaRepository.findByLocal(local)).orElseThrow(
            () -> new UnprocessableEntityException("CNPJ NÃO LOCALIZADO" + local));
            return toDto(hotel);
        
        } catch(UnprocessableEntityException unp){
            throw new UnprocessableEntityException(unp.getMessage() );
        }
        catch(Exception e){
            throw new UnprocessableEntityException("ERRO - AO BUSCAR LOCAL " + e);
        }

}

@SuppressWarnings("unused")
private HotelCaliforniaModel toModel(HotelCaliforniaDto dto){
    HotelCaliforniaModel model = new HotelCaliforniaModel();
    BeanUtils.copyProperties(dto, model);
    return model;
}

private HotelCaliforniaDto toDto(HotelCaliforniaModel model){
    HotelCaliforniaDto dto = new HotelCaliforniaDto();
    dto.setId(model.getId());
    dto.setName(model.getName());
    dto.setLocal(model.getLocal());
    dto.setCnpj(model.getCnpj());
    return dto;
}

public Optional<HotelCaliforniaModel> findCnpj(String cnpj) {
    throw new UnsupportedOperationException("METODO NÃO IMPLEMANTADO 'findCnpj'");
}





}

