package br.com.lfa.AppAluguelVeiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfa.AppAluguelVeiculos.model.Aluguel;
import br.com.lfa.AppAluguelVeiculos.service.AluguelService;

@RestController
@RequestMapping("/api/aluguel") //http://localhost:8080/api/aluguel
public class AluguelController {

	@Autowired
	AluguelService aluguelService;
	
	@PostMapping //POST http://localhost:8080/api/aluguel
	public ResponseEntity<Aluguel> save(@RequestBody Aluguel aluguel){
		Aluguel addAluguel = aluguelService.save(aluguel);
		if (addAluguel == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(addAluguel);
		}
	}
	
	@GetMapping //GET http://localhost:8080/api/aluguel
	public ResponseEntity<List<Aluguel>> findAll(){
		List<Aluguel> aluguel = aluguelService.findAll();
		return ResponseEntity.ok(aluguel);
	}
}
