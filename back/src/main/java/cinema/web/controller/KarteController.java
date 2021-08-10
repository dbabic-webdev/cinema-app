package cinema.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Karta;
import cinema.service.KartaService;
import cinema.support.KartaDtoToKarta;
import cinema.support.KartaToKartaDto;
import cinema.web.dto.KartaDTO;

@RestController
@RequestMapping(value = "/api/karte", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class KarteController {
	
	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private KartaToKartaDto toDto;
	
	@Autowired
	private KartaDtoToKarta toKarta;
	
    @GetMapping("/{id}")
    public ResponseEntity<KartaDTO> getOne(@PathVariable Long id){
       Karta karta = kartaService.findOne(id);

        if(karta != null) {
            return new ResponseEntity<>(toDto.convert(karta), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KartaDTO> create(@Valid @RequestBody KartaDTO dto){
        Karta karta = toKarta.convert(dto);
        Karta saved = kartaService.save(karta);

        return new ResponseEntity<>(toDto.convert(karta), HttpStatus.CREATED);
    }

}
