package br.com.lfa.AppAluguelVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppAluguelVeiculos.model.Cliente;
import br.com.lfa.AppAluguelVeiculos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id){
		return clienteRepository.findById(id);
	}
	
	public Cliente update(Long id, Cliente cliente) {
		Optional<Cliente> findCliente = clienteRepository.findById(id);
		if (findCliente.isPresent()) {
			Cliente updCliente = findCliente.get();
			updCliente.setNome(cliente.getNome());
			updCliente.setEmail(cliente.getEmail());
			updCliente.setCpf(cliente.getCpf());
			updCliente.setDataNascimento(cliente.getDataNascimento());
			return clienteRepository.save(updCliente);
		} else {
			return null;
		}
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
