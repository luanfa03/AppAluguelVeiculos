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

import br.com.lfa.AppAluguelVeiculos.dto.ClienteDTO;
import br.com.lfa.AppAluguelVeiculos.dto.ClienteRequestDTO;
import br.com.lfa.AppAluguelVeiculos.model.Cliente;
import br.com.lfa.AppAluguelVeiculos.service.ClienteService;

@RestController
@RequestMapping("/api/clientes") //http://localhost:8080/api/clientes
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody ClienteRequestDTO cliente){
		Cliente addCliente = clienteService.save(cliente);
		if (addCliente == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(addCliente);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
	    return clienteService.findById(id)
	            .map(cliente -> ResponseEntity.ok(new ClienteDTO(cliente)))
	            .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<ClienteDTO> clientes = clienteService.findAll().stream()
				.map(ClienteDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(clientes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id,  @RequestBody ClienteRequestDTO dto){
		return clienteService.update(id, dto)
				.map(cliente -> ResponseEntity.ok(new ClienteDTO(cliente)))
	    		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
