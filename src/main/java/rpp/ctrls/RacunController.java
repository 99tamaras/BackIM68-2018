package rpp.ctrls;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rpp.model.Racun;
import rpp.service.RacunService;
@CrossOrigin
@RestController
public class RacunController {
	
	  @Autowired
	    private RacunService racunService;

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @GetMapping("racun")
	    public ResponseEntity<List<Racun>> getAll() {
	        List<Racun> racuns = racunService.getAll();
	        return new ResponseEntity<>(racuns, HttpStatus.OK);
	    }
	    
	    @GetMapping("racun/{id}")
	    public ResponseEntity<Racun> getOne(@PathVariable("id") Integer id) {
	        if (racunService.findById(id).isPresent()) {
	            Optional<Racun> racunOpt = racunService.findById(id);
	            return new ResponseEntity<>(racunOpt.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    
	    
	    @PostMapping("racun")
	    public ResponseEntity<Racun> addRacun(@RequestBody Racun racun) {
	        Racun savedRacun = racunService.save(racun);
	        URI location = URI.create("/racun/" + savedRacun.getId());
	        return ResponseEntity.created(location).body(savedRacun);
	    }
	    

	    
	    @PutMapping(value = "racun/{id}")
	    public ResponseEntity<Racun> updateRacun(@RequestBody Racun racun,
	            @PathVariable("id") Integer id) {
	        if (racunService.existsById(id)) {
	        	racun.setId(id);
	            Racun savedRacun = racunService.save(racun);
	            return ResponseEntity.ok().body(savedRacun);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    
	    
	    
	    @DeleteMapping("racun/{id}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
	        if (id == -100 && !racunService.existsById(-100)) {

	            jdbcTemplate.execute("INSERT INTO racun "
	            		+ "(\"id\",\"datum\",  \"nacin_placanja\") "
	            		+ "VALUES (-100,'29.03.2021.', 'kartica' )");
	        }

	        if (racunService.existsById(id)) {
	            racunService.deleteById(id);
	            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	        }
	        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	    }

	    


}
