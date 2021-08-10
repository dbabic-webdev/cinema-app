package cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Sediste;

@Repository
public interface SedisteRepository extends JpaRepository<Sediste, Integer>{
	
	Sediste findOneById (Long id);
	List <Sediste> findBySalaId (Long id);
	

}
