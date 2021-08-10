package cinema.service;

import java.util.List;

import cinema.model.Sala;

public interface SalaService {
	
	Sala findOne (Long id);
	List <Sala> findAll ();

}