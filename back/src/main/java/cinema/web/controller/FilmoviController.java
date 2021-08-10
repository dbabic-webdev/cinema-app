package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Film;
import cinema.model.Projekcija;
import cinema.service.FilmService;
import cinema.service.ProjekcijaService;
import cinema.support.FilmDtoToFilm;
import cinema.support.FilmToFilmDto;
import cinema.support.ProjekcijaToProjekcijaDto;
import cinema.web.dto.FilmDTO;
import cinema.web.dto.ProjekcijaDTO;


@RestController
@RequestMapping(value = "/api/filmovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FilmoviController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private FilmToFilmDto toDto;
	
	@Autowired
	private FilmDtoToFilm toFilm;
	
	@Autowired
	private ProjekcijaToProjekcijaDto toProjekcijaDto;
	

	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO){
        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.save(film);

        return new ResponseEntity<>(toDto.convert(sacuvanFilm), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO){

        if(!id.equals(filmDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Film film = toFilm.convert(filmDTO);
        Film sacuvanFilm = filmService.update(film);

        return new ResponseEntity<>(toDto.convert(sacuvanFilm),HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Film obrisanFilm = filmService.delete(id);


        if(obrisanFilm != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getOne(@PathVariable Long id){
       Film film = filmService.findOne(id);

        if(film != null) {
            return new ResponseEntity<>(toDto.convert(film), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll(
    		@RequestParam(value = "naziv", required = false) String naziv,
      		@RequestParam(value = "zanrovi", required = false) String zanrovi,
      		@RequestParam(value = "trajanjeOd", required = false) Integer trajanjeOd,
      		@RequestParam(value = "trajanjeDo", required = false) Integer trajanjeDo,
    		@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
    	
    	Page <Film> filmovi = filmService.search(naziv, zanrovi, trajanjeOd, trajanjeDo, false, pageNo);
    	

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(filmovi.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(filmovi.getContent()), headers,  HttpStatus.OK);
    }
    
    @GetMapping("/{id}/projekcije")
    public ResponseEntity<List<ProjekcijaDTO>> findByFilmId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Projekcija> projekcije = projekcijaService.findByFilmId(id);

        return new ResponseEntity<>(toProjekcijaDto.convert(projekcije), HttpStatus.OK);
    }
}