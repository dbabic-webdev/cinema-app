package cinema.service;

import java.util.List;

import cinema.model.Karta;

public interface KartaService {
	
	Karta save (Karta karta);
	
	Karta findOne (Long id);
	
	List <Karta> findAll ();
	
	List <Karta> findByProjekcijaId (Long projekcijaId);
	


}