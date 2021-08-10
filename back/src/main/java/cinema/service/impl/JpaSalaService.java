package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Sala;
import cinema.repository.SalaRepository;
import cinema.service.SalaService;

@Service
public class JpaSalaService implements SalaService{
	
	@Autowired
	private SalaRepository salaRepository;

	@Override
	public Sala findOne(Long id) {
		return salaRepository.findOneById(id);
	}

	@Override
	public List<Sala> findAll() {
		return salaRepository.findAll();
	}
}
