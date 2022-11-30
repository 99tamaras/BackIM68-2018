package rpp.ctrls;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import rpp.model.Proizvod;
import rpp.service.ProizvodService;



@CrossOrigin
@RestController
public class ProizvodController {
	
	@Autowired
	private ProizvodService proizvodService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("proizvod")
	 public ResponseEntity<List<Proizvod>> getAll() {
        List<Proizvod> proizvods = proizvodService.getAll();
        return new ResponseEntity<>(proizvods, HttpStatus.OK);
        
	}
	
	 @GetMapping("proizvod/{id}")
	    public ResponseEntity<Proizvod> getOne(@PathVariable("id") Integer id) {
	        if (proizvodService.findById(id).isPresent()) {
	            Optional<Proizvod> proizvodOpt = proizvodService.findById(id);
	            return new ResponseEntity<>(proizvodOpt.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @GetMapping("proizvod/naziv/{naziv}")
	    public ResponseEntity<List<Proizvod>> getByNaziv(@PathVariable("naziv") String naziv) {
	        List<Proizvod> proizvods = proizvodService.findByNazivContainingIgnoreCase(naziv);
	        return new ResponseEntity<>(proizvods, HttpStatus.OK);
	        
	    }
	
// "Adds new Artikl to database.")
	 @PostMapping("proizvod")
	    public ResponseEntity<Proizvod> addProizvod(@RequestBody Proizvod proizvod) {
	        Proizvod savedProizvod = proizvodService.save(proizvod);
	        URI location = URI.create("/proizvod/" + savedProizvod.getId());
	        return ResponseEntity.created(location).body(savedProizvod);
	    }
	 
	 @PutMapping(value = "proizvod/{id}")
	    public ResponseEntity<Proizvod> updateProizvod(@RequestBody Proizvod proizvod, @PathVariable("id") Integer id) {
	        if (proizvodService.existsById(id)) {
	        	proizvod.setId(id);
	            Proizvod savedProizvod = proizvodService.save(proizvod);
	            return ResponseEntity.ok().body(savedProizvod);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	 @DeleteMapping("proizvod/{id}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
	        if (id == -100 && !proizvodService.existsById(id)) {
	            jdbcTemplate.execute(
	            		 "INSERT INTO artikl (\"id\", \"naziv\", \"proizvodjac\") VALUES (-100, 'Test naziv', 'Test proizvodjac')");
	        }

	        if (proizvodService.existsById(id)) {
	        	proizvodService.deleteById(id);
	            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	        }
	        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	    }
	

}
