package rpp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rpp.model.Racun;
import rpp.model.StavkaRacuna;
import rpp.repository.StavkaRacunaRepository;

@Service
public class StavkaRacunaService {
	
	 @Autowired
	    private StavkaRacunaRepository stavkaRacunaRepository;

	    public List<StavkaRacuna> getAll() {
	        return stavkaRacunaRepository.findAll();
	    }

	    public List<StavkaRacuna> findByRacun(Racun racun) {
	        return stavkaRacunaRepository.findByRacun(racun);
	    }

	    public Optional<StavkaRacuna> findById(Integer id) {
	        return stavkaRacunaRepository.findById(id);
	    }

	    public List<StavkaRacuna> findByCenaLessThanOrderById(BigDecimal cena) {
	        return stavkaRacunaRepository.findByCenaLessThanOrderById(cena);
	    }

	    public Integer nextRBr(Integer racunId) {
	        return stavkaRacunaRepository.nextRBr(racunId);
	    }

	    public StavkaRacuna save(StavkaRacuna stavkaRacuna) {
	        return stavkaRacunaRepository.save(stavkaRacuna);
	    }

	    public boolean existsById(Integer id) {
	        return stavkaRacunaRepository.existsById(id);
	    }

	    public void deleteById(Integer id) {
	        stavkaRacunaRepository.deleteById(id);
	    }

}
