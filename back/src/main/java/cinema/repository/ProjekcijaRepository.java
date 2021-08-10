package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Projekcija;


@Repository
public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long>{
	
	Projekcija findOneById (Long id);
	List <Projekcija> findByFilmId (Long id);

}
