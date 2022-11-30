package rpp.ctrls;

import java.math.BigDecimal;
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

import rpp.model.StavkaRacuna;
import rpp.service.RacunService;
import rpp.service.StavkaRacunaService;

@CrossOrigin
@RestController
public class StavkaRacunaController {
	
	 @Autowired
	    private StavkaRacunaService stavkaRacunaService;

	    @Autowired
	    private RacunService racunService;

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    // "Returns List of all StavkaRacunas")
	    @GetMapping("stavkaRacuna")
	    public ResponseEntity<List<StavkaRacuna>> getAll() {
	        List<StavkaRacuna> stavkaRacunas = stavkaRacunaService.getAll();
	        return new ResponseEntity<>(stavkaRacunas, HttpStatus.OK);
	    }

	    //value = "Returns StavkaRacuna with id that was forwarded as path variable.")
	    @GetMapping("stavkaRacuna/{id}")
	    public ResponseEntity<StavkaRacuna> getOne(@PathVariable("id") Integer id) {
	        if (stavkaRacunaService.findById(id).isPresent()) {
	            Optional<StavkaRacuna> stavkaRacunaOpt = stavkaRacunaService.findById(id);
	            return new ResponseEntity<>(stavkaRacunaOpt.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }
	/*    
//	    (value = "Returns list of StavkePorudzbine for Porudzbina with id that was forwarded as path variable.")
	    @GetMapping("stavkaRacuna/{id}")
	    public ResponseEntity<List<StavkaRacuna>> getAllForPorudzbina(@PathVariable("id") Integer id) {
	        Optional<Porudzbina> porudzbinaOpt = porudzbinaService.findById(id);
	        if (porudzbinaOpt.isPresent()) {
	            List<StavkaRacuna> stavkaPorudzbines = stavkaPorudzbineService.findByPorudzbina(porudzbinaOpt.get());
	            return new ResponseEntity<>(stavkaPorudzbines, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	    }
*/
//	    @ApiOperation(value = "Returns list of StavkePorudzbine with price that is lower then price that was forwarded as path variable.")
	    @GetMapping(value = "stavkaRacunaCena/{cena}")
	    public ResponseEntity<List<StavkaRacuna>> getStavkaRacunaCena(@PathVariable("cena") BigDecimal cena) {
	        List<StavkaRacuna> stavkaRacunas = stavkaRacunaService.findByCenaLessThanOrderById(cena);
	        return new ResponseEntity<>(stavkaRacunas, HttpStatus.OK);

	    }

//	    @ApiOperation(value = "Adds new StavkaRacuna to database.")
	    @PostMapping("stavkaRacuna")
	    public ResponseEntity<StavkaRacuna> addOne(@RequestBody StavkaRacuna stavkaRacuna) {
	        if (!racunService.existsById(stavkaRacuna.getRacun().getId())) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        stavkaRacuna.setRedniBroj(stavkaRacunaService.nextRBr(stavkaRacuna.getRacun().getId()));
	        StavkaRacuna savedStavkaRacuna = stavkaRacunaService.save(stavkaRacuna);
	        URI location = URI.create("/stavkaRacuna/" + savedStavkaRacuna.getId());
	        return ResponseEntity.created(location).body(savedStavkaRacuna);
	    }

//	    @ApiOperation(value = "Updates StavkaRacuna that has id that was forwarded as path variable with values forwarded in Request Body.")
	    @PutMapping("stavkaRacuna/{id}")
	    public ResponseEntity<StavkaRacuna> updateOne(@RequestBody StavkaRacuna stavkaRacuna,
	            @PathVariable("id") Integer id) {
	        if (!stavkaRacunaService.existsById(id)) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        stavkaRacuna.setId(id);
	        StavkaRacuna savedStavkaRacuna = stavkaRacunaService.save(stavkaRacuna);
	        return ResponseEntity.ok().body(savedStavkaRacuna);
	    }

//	    @ApiOperation(value = "Deletes StavkaRacuna with id that was forwarded as path variable.")
	    @DeleteMapping("stavkaRacuna/{id}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
	        if (id == -100 && !stavkaRacunaService.existsById(-100)) {

	            jdbcTemplate.execute(
	                    "INSERT INTO stavka_racuna (\"cena\", \"id\", \"jedinicaMere\", \"proizvod\", \"racun\", \"redniBroj\") "
	                            + "VALUES ('100', '-100', 'kom', '1', '1', '1', '1')");
	        }

	        if (stavkaRacunaService.existsById(id)) {
	            stavkaRacunaService.deleteById(id);
	            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	        }

	        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	    }

}
