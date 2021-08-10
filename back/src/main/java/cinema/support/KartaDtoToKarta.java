package cinema.support;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Karta;
import cinema.service.KartaService;
import cinema.service.ProjekcijaService;
import cinema.web.dto.KartaDTO;

@Component
public class KartaDtoToKarta implements Converter<KartaDTO, Karta>{
	
	@Autowired
	private KartaService kartaService;
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private SedisteDtoToSediste toSediste;

	@Override
	public Karta convert(KartaDTO dto) {
		Karta karta = new Karta();
		
		if (dto.getId() != null) {
			karta = kartaService.findOne(dto.getId());
		} 
		
		if (karta == null) {
			karta = new Karta();
		}
		
		karta.setDatum(LocalDate.now());
		karta.setProjekcija(projekcijaService.findOne(dto.getProjekcijaId()));
		karta.setSediste(toSediste.convert(dto.getSedista()));
	
		return karta;
	}

}
