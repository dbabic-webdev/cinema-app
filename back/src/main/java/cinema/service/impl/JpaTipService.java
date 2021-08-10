package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Tip;
import cinema.repository.TipRepository;
import cinema.service.TipService;

@Service
public class JpaTipService implements TipService{
	
	@Autowired
	private TipRepository tipRepository;

	@Override
	public Tip findOne(Long id) {
		return tipRepository.findOneById(id);
	}

	@Override
	public List<Tip> findAll() {
		return tipRepository.findAll();
	}

}
