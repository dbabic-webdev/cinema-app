package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Karta;
import cinema.web.dto.KartaDTO;

@Component
public class KartaToKartaDto implements Converter<Karta, KartaDTO>{
	
	@Autowired
	private SedisteToSedisteDto toSedisteDto;
	

	@Override
	public KartaDTO convert(Karta karta) {
		KartaDTO dto = new KartaDTO();
		dto.setDatum(karta.getDatum().toString());
		dto.setId(karta.getId());
		dto.setProjekcijaDatum(karta.getProjekcija().getDatumIVreme().toString());
		dto.setProjekcijaFilm(karta.getProjekcija().getFilm().getNaziv());
		dto.setProjekcijaId(karta.getProjekcija().getId());
		dto.setSedista(toSedisteDto.convert(karta.getSediste()));
		return dto;
	}
	
    public List<KartaDTO> convert(List<Karta> karte){
        List<KartaDTO> dtos = new ArrayList<>();

        for(Karta k : karte) {
        	KartaDTO dto = convert(k);
            dtos.add(dto);
        }

        return dtos;
    }

}
