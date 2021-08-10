package cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cinema.model.Film;

public interface FilmService {
	
	Film findOne (Long id);
	
	List <Film> findAll ();
	
	Film save (Film film);
	
	Film delete (Long id);
	
	Film update (Film film);
	
	Iterable <Film> findAllMovies ();
	
	Page <Film> findAll (boolean isDeleted, int pageNo);
	
	Page <Film> search (String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, boolean isDeleted, int pageNo);
	
	void remove (Long id);

}
