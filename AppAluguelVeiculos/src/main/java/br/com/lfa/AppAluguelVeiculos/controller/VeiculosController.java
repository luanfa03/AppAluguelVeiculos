package br.com.lfa.AppAluguelVeiculos.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import br.com.lfa.AppAluguelVeiculos.dto.VeiculoDTO;
import br.com.lfa.AppAluguelVeiculos.dto.VeiculoRequestDTO;
import br.com.lfa.AppAluguelVeiculos.model.Veiculos;
import br.com.lfa.AppAluguelVeiculos.service.VeiculosService;

@RestController
@RequestMapping("/api/veiculos") //http://localhost:8080/api/veiculos
public class VeiculosController {
	
	@Autowired
	VeiculosService veiculosService;
	
	@PostMapping //POST http://localhost:8080/api/veiculos
	public ResponseEntity<Veiculos> save(@RequestBody VeiculoRequestDTO veiculos){
		Veiculos addVeiculo = veiculosService.save(veiculos);
		if (addVeiculo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(addVeiculo);
		}
	}
	
	@GetMapping //GET http://localhost:8080/api/veiculos
	public ResponseEntity<List<VeiculoDTO>> findAll(){
		List<VeiculoDTO> veiculos = veiculosService.findAll()
				.stream()
				.map(VeiculoDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(veiculos);
	}
	
	@GetMapping("/disponiveis") //GET http://localhost:8080/api/veiculos/disponiveis
	public ResponseEntity<List<VeiculoDTO>> findDisponivel(){
		List<VeiculoDTO> veiculosDisponiveis = veiculosService.findDisponiveis()
				.stream()
				.map(VeiculoDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(veiculosDisponiveis);
	}
	
	@GetMapping("/{id}")//GET http://localhost:8080/api/veiculos/disponiveis/{id}
	public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
	    return veiculosService.findById(id)
	            .map(veiculo -> ResponseEntity.ok(new VeiculoDTO(veiculo)))
	            .orElse(ResponseEntity.notFound().build());
	}

	
	@PutMapping("/{id}")//PUT http://localhost:8080/api/veiculos/{id}
	public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoRequestDTO dto) {
	    return veiculosService.update(id, dto)
	    		.map(veiculo -> ResponseEntity.ok(new VeiculoDTO(veiculo)))
	    		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")//DELETE http://localhost:8080/api/veiculos/{id}
	public ResponseEntity<?> delete(@PathVariable Long id){
		veiculosService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
