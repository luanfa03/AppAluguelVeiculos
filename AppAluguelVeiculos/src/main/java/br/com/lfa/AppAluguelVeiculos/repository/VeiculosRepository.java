package br.com.lfa.AppAluguelVeiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lfa.AppAluguelVeiculos.model.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long>{
	List<Veiculos> findByDisponivelTrue();
}
