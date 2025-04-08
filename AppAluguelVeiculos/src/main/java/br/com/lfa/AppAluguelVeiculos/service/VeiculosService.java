package br.com.lfa.AppAluguelVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppAluguelVeiculos.model.Veiculos;
import br.com.lfa.AppAluguelVeiculos.repository.VeiculosRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository veiculosRepository;
	
	public Veiculos save(Veiculos veiculos) {
		return veiculosRepository.save(veiculos);
	}
	
	public List<Veiculos> findAll(){
		return veiculosRepository.findAll();
	}
	
	public Optional<Veiculos> findById(Long id){
		return veiculosRepository.findById(id);
	}
	
	public Veiculos update(Long id, Veiculos veiculo) {
		Optional<Veiculos> findVeiculo = veiculosRepository.findById(id);
		if(findVeiculo.isPresent()) {
			Veiculos updVeiculos = findVeiculo.get();
			updVeiculos.setModelo(veiculo.getModelo());
			updVeiculos.setMarca(veiculo.getMarca());
			updVeiculos.setAno(veiculo.getAno());
			updVeiculos.setPlaca(veiculo.getPlaca());
			return veiculosRepository.save(updVeiculos);
		}
		return null;
	}
	
	public void delete(Long id) {
		veiculosRepository.deleteById(id);
	}
}
