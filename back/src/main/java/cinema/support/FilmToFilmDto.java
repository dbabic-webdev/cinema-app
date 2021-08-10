package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Film;
import cinema.web.dto.FilmDTO;

@Component
public class FilmToFilmDto implements Converter <Film, FilmDTO>{

	@Override
	public FilmDTO convert(Film film) {
		FilmDTO dto = new FilmDTO();
		dto.setId(film.getId());
		dto.setGlumci(film.getGlumci());
		dto.setGodinaProizvodnje(film.getGodinaProizvodnje());
		dto.setDistributer(film.getDistributer());
		dto.setNaziv(film.getNaziv());
		dto.setOpis(film.getOpis());
		dto.setReziser(film.getReziser());
		dto.setTrajanje(film.getTrajanje());
		dto.setZanrovi(film.getZanrovi());
		dto.setZemljaPorekla(film.getZemljaPorekla());
		return dto;
	}
	
    public List<FilmDTO> convert(List<Film> filmovi){
        List<FilmDTO> dtos = new ArrayList<>();

        for(Film k : filmovi) {
            FilmDTO dto = convert(k);
            dtos.add(dto);
        }

        return dtos;
    }
}
