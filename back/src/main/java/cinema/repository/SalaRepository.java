package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
	
	Sala findOneById (Long id);
	
}