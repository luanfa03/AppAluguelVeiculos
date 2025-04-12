package br.com.lfa.AppAluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lfa.AppAluguelVeiculos.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{

}
