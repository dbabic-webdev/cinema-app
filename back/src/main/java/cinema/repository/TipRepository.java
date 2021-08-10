package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Tip;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long>{
	
	Tip findOneById (Long id);
}