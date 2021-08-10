package cinema.service;

import java.util.List;

import cinema.model.Tip;

public interface TipService {
	
	Tip findOne (Long id);
	
	List <Tip> findAll();

}