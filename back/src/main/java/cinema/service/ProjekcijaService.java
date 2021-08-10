package cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cinema.model.Projekcija;

public interface ProjekcijaService {
	
	Projekcija findOne (Long id);
	List <Projekcija> findAll ();
	
	Projekcija save (Projekcija projekcija);
	Projekcija delete (Long id);
	Projekcija update (Projekcija projekcija);
	
	Page <Projekcija> findAll (int pageNo);
	
	List <Projekcija> findByFilmId (Long id);

}
