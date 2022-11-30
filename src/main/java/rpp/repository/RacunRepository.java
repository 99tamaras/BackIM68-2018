package rpp.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rpp.model.Racun;

public interface RacunRepository extends JpaRepository <Racun, Integer>{

	

	Optional<Racun> findById(Integer id);
	
	
	

}
