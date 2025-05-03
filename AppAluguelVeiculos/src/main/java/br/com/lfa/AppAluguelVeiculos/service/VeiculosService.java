package br.com.lfa.AppAluguelVeiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppAluguelVeiculos.dto.VeiculoRequestDTO;
import br.com.lfa.AppAluguelVeiculos.model.Veiculos;
import br.com.lfa.AppAluguelVeiculos.repository.VeiculosRepository;

@Service
public class VeiculosService {

	@Autowired
	private VeiculosRepository veiculosRepository;
	
	public Veiculos save(VeiculoRequestDTO dto) {
		Veiculos veiculo = new Veiculos();
		veiculo.setModelo(dto.getModelo());
		veiculo.setMarca(dto.getMarca());
		veiculo.setPlaca(dto.getPlaca());
		veiculo.setDisponivel(dto.getDisponivel());
		veiculo.setAno(dto.getAno());
		return veiculosRepository.save(veiculo);
	}
	
	public List<Veiculos> findAll(){
		return veiculosRepository.findAll();
	}
	
	public Optional<Veiculos> findById(Long id){
		return veiculosRepository.findById(id);
	}
	
	public List<Veiculos> findDisponiveis(){
		return veiculosRepository.findByDisponivelTrue();
	}
	
	public Optional<Veiculos> update(Long id, VeiculoRequestDTO dto) {
	    return veiculosRepository.findById(id).map(veiculo -> {
	        veiculo.setMarca(dto.getMarca());
	        veiculo.setModelo(dto.getModelo());
	        veiculo.setPlaca(dto.getPlaca());
	        veiculo.setDisponivel(dto.getDisponivel());
	        veiculo.setAno(dto.getAno());
	        return veiculosRepository.save(veiculo);
	    });
	}
	
	public void delete(Long id) {
		veiculosRepository.deleteById(id);
	}
}
