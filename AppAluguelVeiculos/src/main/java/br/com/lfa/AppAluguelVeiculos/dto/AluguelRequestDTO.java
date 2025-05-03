package br.com.lfa.AppAluguelVeiculos.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AluguelRequestDTO {
	
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	
	private Double valorTotal;
	
	private ClienteDTO cliente;
	private VeiculoDTO veiculo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public VeiculoDTO getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
}
