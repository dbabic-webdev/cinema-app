package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projekcija;
import cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaToProjekcijaDto implements Converter<Projekcija, ProjekcijaDTO>{
	
	@Autowired
	private TipToTipDto toTipDto;
	
	@Autowired
	private SalaToSalaDto toSalaDto;
	
	@Autowired
	private FilmToFilmDto toFilmDto;
	

	@Override
	public ProjekcijaDTO convert(Projekcija projekcija) {
		ProjekcijaDTO dto = new ProjekcijaDTO();
		dto.setCena(projekcija.getCena());
		dto.setFilm(toFilmDto.convert(projekcija.getFilm()));
		dto.setDatumIVreme(projekcija.getDatumIVreme().toString());
		dto.setId(projekcija.getId());
		dto.setSala(toSalaDto.convert(projekcija.getSala()));
		dto.setTip(toTipDto.convert(projekcija.getTip()));
		return dto;
	}
	
    public List<ProjekcijaDTO> convert(List<Projekcija> projekcije){
        List<ProjekcijaDTO> projekcijeDto = new ArrayList<>();

        for(Projekcija projekcija : projekcije) {
            projekcijeDto.add(convert(projekcija));
        }

        return projekcijeDto;
    }

}
