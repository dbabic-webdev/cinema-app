package cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Sala;
import cinema.model.Sediste;
import cinema.web.dto.SalaDTO;

@Component
public class SalaToSalaDto implements Converter <Sala, SalaDTO>{
	
	@Autowired
	private SedisteToSedisteDto toDto;

	@Override
	public SalaDTO convert(Sala sala) {
		SalaDTO dto = new SalaDTO();
		dto.setId(sala.getId());
		dto.setNaziv(sala.getNaziv());
		List <Sediste> sedista = new ArrayList<>(sala.getSedista());
		dto.setSedista(new HashSet <>(toDto.convert(sedista)));;
		return dto;
	}
	
    public List<SalaDTO> convert(List<Sala> sale){
        List<SalaDTO> dtos = new ArrayList<>();

        for(Sala sala : sale) {
        	dtos.add(convert(sala));
        }

        return dtos;
    }

}
