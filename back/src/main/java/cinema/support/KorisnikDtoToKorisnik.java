package cinema.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Korisnik;
import cinema.service.KorisnikService;
import cinema.web.dto.KorisnikDTO;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, Korisnik> {

	@Autowired
	private KorisnikService korisnikService;

    @Override
    public Korisnik convert(KorisnikDTO korisnikDTO) {
        Korisnik korisnik = null;
        if(korisnikDTO.getId() != null) {
            korisnik = korisnikService.findOne(korisnikDTO.getId()).get();
        }

        if(korisnik == null) {
            korisnik = new Korisnik();
        }

        korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        korisnik.seteMail(korisnikDTO.geteMail());
        korisnik.setIme(korisnikDTO.getIme());
        korisnik.setPrezime(korisnikDTO.getPrezime());

        return korisnik;
    }

}
