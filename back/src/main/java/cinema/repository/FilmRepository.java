package cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cinema.model.Film;


@Repository
public interface FilmRepository extends JpaRepository <Film, Long>{
	
	Film findOneById (Long id);
	
//	@Query("SELECT f FROM Film f WHERE" +
//			"(:naziv = NULL OR f.naziv LIKE :naziv) AND " + 
//			"(:zanrovi = NULL OR f.zanrovi LIKE :zanrovi)")
//	Page<Film> search(@Param("naziv") String naziv, @Param("zanrovi") String zanrovi, Pageable pageable);
	
	Page<Film> findByNazivIgnoreCaseContainsAndZanroviIgnoreCaseContainsAndTrajanjeBetween(String naziv, String zanrovi, int trajanjeOd, int trajanjeDo, Pageable pageable);

}
