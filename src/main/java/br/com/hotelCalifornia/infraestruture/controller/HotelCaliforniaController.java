package br.com.hotelCalifornia.infraestruture.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelCalifornia.infraestruture.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestruture.repository.HotelCaliforniaRepository;
import br.com.hotelCalifornia.infraestruture.service.HotelCalioforniaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/hotel")

public class HotelCaliforniaController {
    
    public final HotelCalioforniaService hotelCalioforniaService;

    public HotelCaliforniaController(HotelCalioforniaService hotelCalioforniaService){
        this.hotelCalioforniaService = hotelCalioforniaService;
}

    @PostMapping    
    public ResponseEntity<HotelCaliforniaModel> save(@RequestBody HotelCaliforniaModel hotelCaliforniaModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelCalioforniaService.salvarHotel(hotelCaliforniaModel));
    }
    
    @GetMapping
    public ResponseEntity<List<HotelCaliforniaModel>> findAll(){
      List<HotelCaliforniaModel> listaHoteis= hotelCalioforniaService.listarHotel();

      if(listaHoteis.isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    return new ResponseEntity<>(listaHoteis,HttpStatus.OK);
}
    
//buscar Hotel por id
@GetMapping("/{id}")
public ResponseEntity<HotelCaliforniaModel> buscarHotelId(@PathVariable UUID id){
    Optional<HotelCaliforniaModel> hotel = hotelCalioforniaService.buscarHotelId(id);
    if(hotel.isPresent()){
        return new ResponseEntity<>(hotel.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PutMapping("/{id}")
public ResponseEntity<HotelCaliforniaModel> atualizarHotel(@PathVariable UUID id, @RequestBody HotelCaliforniaModel hotel) {
    HotelCaliforniaModel hotelAtualizado = hotelCalioforniaService.atualizarHotel(id, hotel);
    if (hotelAtualizado != null) {
        
        return new ResponseEntity<>(hotelAtualizado, HttpStatus.OK);
    }
    
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

// Deletar um hotel
@DeleteMapping("/{id}")
public ResponseEntity<Void> apagarHotel(@PathVariable UUID id) {
    boolean apagado = hotelCalioforniaService.apagarHotel(id);
    if (apagado) {  
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


     





}
