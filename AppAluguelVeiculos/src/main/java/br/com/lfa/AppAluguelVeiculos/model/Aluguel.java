package br.com.lfa.AppAluguelVeiculos.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn (name = "veiculo_id", nullable = false)
	private Veiculos veiculo;
	
	@ManyToOne
	@JoinColumn (name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	
	@Column()
	private Double valorTotal;
	
	public Aluguel() {};
	
	public Aluguel(Long id, Veiculos veiculo, Cliente cliente, LocalDate dataInicio, LocalDate dataFim, Double valorTotal) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	};
	
	@Override
	public String toString() {
		return "ID Aluguel: " + this.id + "ID Veículo: "
				+ this.veiculo.getId() + "ID Cliente: " + this.cliente.getId() + "Data Início: " + this.dataInicio
				+ "Data Fim: " + this.dataFim + "Valor Total: " + this.valorTotal;
	}
}

