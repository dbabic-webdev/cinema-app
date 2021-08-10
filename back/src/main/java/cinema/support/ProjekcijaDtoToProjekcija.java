package cinema.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projekcija;
import cinema.service.FilmService;
import cinema.service.ProjekcijaService;
import cinema.service.SalaService;
import cinema.service.TipService;
import cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaDtoToProjekcija implements Converter<ProjekcijaDTO, Projekcija>{
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private TipService tipService;
	
	@Autowired
	private FilmService filmService;

	@Override
	public Projekcija convert(ProjekcijaDTO dto) {
		Projekcija projekcija;
		if (dto.getId() == null) {
			projekcija = new Projekcija();
		} else {
			projekcija = projekcijaService.findOne(dto.getId());
		}
		
		if (projekcija != null) {
			projekcija.setDatumIVreme(getLocalDateTime(dto.getDatumIVreme()));
			projekcija.setCena(dto.getCena());
			projekcija.setFilm(filmService.findOne(dto.getFilm().getId()));
			projekcija.setTip(tipService.findOne(dto.getTip().getId()));
			projekcija.setSala(salaService.findOne(dto.getSala().getId()));
			projekcija.setId(dto.getId());
		}
		
		return projekcija;
	}
	
    private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(datumIVreme, formatter);
    }

}
