package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Sediste;
import cinema.repository.SedisteRepository;
import cinema.service.SedisteService;


@Service
public class JpaSedisteService implements SedisteService{
	
	@Autowired
	private SedisteRepository sedisteRepository;

	@Override
	public Sediste findOne(Long id) {
		return sedisteRepository.findOneById(id);
	}

	@Override
	public List<Sediste> findAll() {
		return sedisteRepository.findAll();
	}

	@Override
	public List<Sediste> findBySala(Long id) {
		return sedisteRepository.findBySalaId(id);
	}

}
