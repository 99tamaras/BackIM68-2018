package rpp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpp.model.Racun;
import rpp.repository.RacunRepository;

@Service
public class RacunService {

	@Autowired
	private RacunRepository racunRepository;
	
	public List<Racun> getAll(){
		return racunRepository.findAll();
	}
	
	public Optional<Racun> findById(Integer id) {
		return racunRepository.findById(id);
	}
	
	public Racun save(Racun racun) {
		return racunRepository.save(racun);
	}
	
	public boolean existsById(Integer id) {
		return racunRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		racunRepository.deleteById(id);
	}

}
