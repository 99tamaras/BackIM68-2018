package rpp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rpp.model.Proizvod;

//parametri- klasa na koju se odnosi i tip kljuca te klase
public interface ProizvodRepository extends JpaRepository <Proizvod, Integer>{
	
	List<Proizvod> findByNazivContainingIgnoreCase(String naziv);
	

}
