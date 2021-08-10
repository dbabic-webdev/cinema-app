package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Tip;
import cinema.web.dto.TipDTO;

@Component
public class TipToTipDto implements Converter<Tip, TipDTO>{

	@Override
	public TipDTO convert(Tip tip) {
		TipDTO dto = new TipDTO();
		dto.setId(tip.getId());
		dto.setNaziv(tip.getNaziv());
		return dto;
	}
	
    public List<TipDTO> convert(List<Tip> tipovi){
        List<TipDTO> dtos = new ArrayList<>();

        for(Tip k : tipovi) {
        	TipDTO dto = convert(k);
            dtos.add(dto);
        }

        return dtos;
    }

}
