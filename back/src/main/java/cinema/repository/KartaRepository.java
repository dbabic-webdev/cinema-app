package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Karta;


@Repository
public interface KartaRepository extends JpaRepository<Karta, Long>{
	
	Karta findOneById (Long id);
	
	List <Karta> findByProjekcijaId (Long projekcijaId);
	

}
