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

import br.com.lfa.AppAluguelVeiculos.model.Cliente;
import br.com.lfa.AppAluguelVeiculos.service.ClienteService;

@RestController
@RequestMapping("/api/clientes") //http://localhost:8080/api/clientes
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente addCliente = clienteService.save(cliente);
		if (addCliente == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(addCliente);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id){
		Optional<Cliente> findCliente = clienteService.findById(id);
		if (findCliente == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(findCliente);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,  @RequestBody Cliente cliente){
		Optional<Cliente> findCliente = clienteService.findById(id);
		if (findCliente.isPresent()) {
			return ResponseEntity.ok(clienteService.update(id, cliente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
