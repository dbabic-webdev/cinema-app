package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Sediste;
import cinema.web.dto.SedisteDTO;

@Component
public class SedisteToSedisteDto implements Converter <Sediste, SedisteDTO>{
	

	@Override
	public SedisteDTO convert(Sediste sediste) {
		SedisteDTO dto = new SedisteDTO();
		dto.setRedniBroj(sediste.getId());
		
		return dto;
	}
	
    public List<SedisteDTO> convert(List<Sediste> sedista){
        List<SedisteDTO> dtos = new ArrayList<>();

        for(Sediste sediste : sedista) {
        	dtos.add(convert(sediste));
        }

        return dtos;
    }

}
