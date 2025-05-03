package br.com.lfa.AppAluguelVeiculos.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppAluguelVeiculos.dto.ClienteRequestDTO;
import br.com.lfa.AppAluguelVeiculos.model.Cliente;
import br.com.lfa.AppAluguelVeiculos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(ClienteRequestDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setCpf(dto.getCpf());
		cliente.setDataNascimento(dto.getDataNascimento());
		if(isMaiorDeIdade(cliente.getDataNascimento()) == true) {
			return clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("Cliente deve ter pelo menos 18 anos.");
		}
		
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(Long id){
		return clienteRepository.findById(id);
	}
	
	public Optional<Cliente> update(Long id, ClienteRequestDTO dto) {
	    return clienteRepository.findById(id).map(cliente -> {
	    	cliente.setNome(dto.getNome());
			cliente.setEmail(dto.getEmail());
			cliente.setCpf(dto.getCpf());
			cliente.setDataNascimento(dto.getDataNascimento());
	        return clienteRepository.save(cliente);
	    });
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
	private boolean isMaiorDeIdade(LocalDate dataDeNascimento) {
		return Period.between(dataDeNascimento, LocalDate.now()).getYears() >= 18;
	}

}
