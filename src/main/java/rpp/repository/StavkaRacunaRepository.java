package rpp.repository;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rpp.model.Racun;
import rpp.model.StavkaRacuna;

public interface StavkaRacunaRepository extends JpaRepository <StavkaRacuna, Integer>{
	
	 List<StavkaRacuna> findByRacun(Racun racun);
	 List<StavkaRacuna> findByCenaLessThanOrderById(BigDecimal cena);
	
	   @Query(value = "select coalesce(max(redniBroj)+1, 1) from stavka_racuna where racun = ?1", nativeQuery = true)
	    Integer nextRBr(Integer racunId);

}
