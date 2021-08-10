package cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Tip;
import cinema.service.TipService;
import cinema.support.TipToTipDto;
import cinema.web.dto.TipDTO;


@RestController
@RequestMapping(value = "/api/tipovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TipController {
	
	@Autowired
	private TipService tipService;
	
	@Autowired
	private TipToTipDto toDto;
	
	@GetMapping
    public ResponseEntity<List<TipDTO>> getAll(){

	        List <Tip> tipovi = tipService.findAll();

	        return new ResponseEntity<>(toDto.convert(tipovi), HttpStatus.OK);
	    }
}
