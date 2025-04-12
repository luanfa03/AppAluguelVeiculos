package br.com.lfa.AppAluguelVeiculos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfa.AppAluguelVeiculos.model.Veiculos;
import br.com.lfa.AppAluguelVeiculos.service.VeiculosService;

@RestController
@RequestMapping("/api/veiculos") //http://localhost:8080/api/veiculos
public class VeiculosController {
	
	@Autowired
	VeiculosService veiculosService;
	
	@PostMapping //POST http://localhost:8080/api/veiculos
	public ResponseEntity<Veiculos> save(@RequestBody Veiculos veiculos){
		Veiculos addVeiculo = veiculosService.save(veiculos);
		if (addVeiculo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(addVeiculo);
		}
	}
	
	@GetMapping //GET http://localhost:8080/api/veiculos
	public ResponseEntity<List<Veiculos>> findAll(){
		List<Veiculos> veiculos = veiculosService.findAll();
		return ResponseEntity.ok(veiculos);
	}
	
	@GetMapping("/disponiveis") //GET http://localhost:8080/api/veiculos/disponiveis
	public ResponseEntity<List<Veiculos>> findDisponivel(){
		List<Veiculos> veiculosDisponiveis = veiculosService.findDisponiveis();
		return ResponseEntity.ok(veiculosDisponiveis);
	}
	
	@GetMapping("/{id}") //GET http://localhost:8080/api/veiculos/{id}
	public ResponseEntity<Optional<Veiculos>> findById(@PathVariable Long id){
		Optional<Veiculos> veiculos = veiculosService.findById(id);
		if (veiculos == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(veiculos);
		}
	}
	
	@PutMapping("/{id}")//PUT http://localhost:8080/api/veiculos/{id}
	public ResponseEntity<Veiculos> update(@PathVariable Long id, @RequestBody Veiculos veiculo){
		Optional<Veiculos> findVeiculo = veiculosService.findById(id);
		if(findVeiculo.isPresent()) {
			return ResponseEntity.ok(veiculosService.update(id, veiculo));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")//DELETE http://localhost:8080/api/veiculos/{id}
	public ResponseEntity<?> delete(@PathVariable Long id){
		veiculosService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
