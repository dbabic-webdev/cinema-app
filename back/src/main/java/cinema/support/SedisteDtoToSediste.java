package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Sediste;
import cinema.service.SedisteService;
import cinema.web.dto.SedisteDTO;

@Component
public class SedisteDtoToSediste implements Converter<SedisteDTO, Sediste>{
	
	@Autowired
	private SedisteService sedisteService;

	@Override
	public Sediste convert(SedisteDTO dto) {
		Sediste sediste = new Sediste();
		
		if (dto.getRedniBroj() != null) {
			sediste = sedisteService.findOne(dto.getRedniBroj());			
		}
		
		if (sediste == null) {
			sediste = new Sediste();
		}
		
		sediste.setId(dto.getRedniBroj());
		
		
		return sediste;
	}
	
    public List<Sediste> convert(List<SedisteDTO> sedistaDto){
        List<Sediste> sedista = new ArrayList<>();

        for(SedisteDTO projekcija : sedistaDto) {
        	sedista.add(convert(projekcija));
        }

        return sedista;
    }

}
