package br.com.lfa.AppAluguelVeiculos.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfa.AppAluguelVeiculos.model.Aluguel;
import br.com.lfa.AppAluguelVeiculos.model.Cliente;
import br.com.lfa.AppAluguelVeiculos.model.Veiculos;
import br.com.lfa.AppAluguelVeiculos.repository.AluguelRepository;
import br.com.lfa.AppAluguelVeiculos.repository.ClienteRepository;
import br.com.lfa.AppAluguelVeiculos.repository.VeiculosRepository;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private VeiculosRepository veiculoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Aluguel save(Aluguel aluguel) {
		Long veiculoId = aluguel.getVeiculo().getId();
	    Veiculos veiculo = veiculoRepository.findById(veiculoId)
	        .orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + veiculoId));
	    
	    Long clienteId = aluguel.getCliente().getId();
	    Cliente cliente = clienteRepository.findById(clienteId)
	    		.orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + clienteId));
	    
		if (Boolean.TRUE.equals(veiculo.getDisponivel())) {
			
			double dias = ChronoUnit.DAYS.between(aluguel.getDataInicio(), aluguel.getDataFim());
			aluguel.setValorTotal(dias * 100); // preço fixo por dia de 100 reais 
			
			veiculo.setDisponivel(false);
			veiculoRepository.save(veiculo);
			
			aluguel.setVeiculo(veiculo);	
			aluguel.setCliente(cliente);
			
			return aluguelRepository.save(aluguel);
		} else {
			throw new RuntimeException("Veículo não disponível.");
		}
	}
	
	public List<Aluguel> findAll(){
		return aluguelRepository.findAll();
	}
}
