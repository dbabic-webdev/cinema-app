package cinema.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cinema.model.Film;
import cinema.repository.FilmRepository;
import cinema.service.FilmService;


@Service
public class JpaFilmService implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Film findOne(Long id) {
		return filmRepository.findOneById(id);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	public Film save(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Film delete(Long id) {
		Optional <Film> film = filmRepository.findById(id);
		if (film.isPresent()) {
			filmRepository.deleteById(id);
			return film.get();
		}
		return null;
	}

	@Override
	public Film update(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public Iterable<Film> findAllMovies() {
		return filmRepository.findAll();
	}

	@Override
	public Page<Film> findAll(boolean isDeleted, int pageNo) {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedFilmFilter");
		filter.setParameter("isDeleted", isDeleted);
		Page <Film> filmovi = filmRepository.findAll(PageRequest.of(pageNo, 5));
		session.disableFilter("deletedFilmFilter");
		return filmovi;
	}

	@Override
	public void remove(Long id) {
		filmRepository.deleteById(id);	
	}

	@Override
	public Page<Film> search(String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, boolean isDeleted, int pageNo) {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedFilmFilter");
		filter.setParameter("isDeleted", isDeleted);
		if (naziv == null) {
			naziv ="";
		}
		if (zanrovi == null) {
			zanrovi = "";
		}
		if (trajanjeOd == null) {
			trajanjeOd = 0;
		}
		if (trajanjeDo == null) {
			trajanjeDo = 1000;
		}
		
		Page <Film> filmovi = filmRepository.findByNazivIgnoreCaseContainsAndZanroviIgnoreCaseContainsAndTrajanjeBetween(naziv, zanrovi, trajanjeOd, trajanjeDo, PageRequest.of(pageNo, 5));
		session.disableFilter("deletedFilmFilter");
		return filmovi;
	}


}
