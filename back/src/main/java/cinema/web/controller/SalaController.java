package cinema.web.controller;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Sala;
import cinema.model.Sediste;
import cinema.service.SalaService;
import cinema.service.SedisteService;
import cinema.support.SalaToSalaDto;
import cinema.support.SedisteToSedisteDto;
import cinema.web.dto.SalaDTO;
import cinema.web.dto.SedisteDTO;


@RestController
@RequestMapping(value = "/api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaToSalaDto toDto;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteToSedisteDto toSedisteDto;
	
    @GetMapping("/{id}")
    public ResponseEntity<List<SedisteDTO>> findBySalaId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Sediste> projekcije = sedisteService.findBySala(id);

        return new ResponseEntity<>(toSedisteDto.convert(projekcije), HttpStatus.OK);
    }
    
	@GetMapping
    public ResponseEntity<List<SalaDTO>> getAll(){

	        List <Sala> sale = salaService.findAll();

	        return new ResponseEntity<>(toDto.convert(sale), HttpStatus.OK);
	    }
}
