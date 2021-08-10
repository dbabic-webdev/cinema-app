package cinema.service;

import java.util.List;

import cinema.model.Sediste;


public interface SedisteService {
	
	Sediste findOne (Long id);
	
	List <Sediste> findAll ();
	
	List <Sediste> findBySala (Long id);

}
