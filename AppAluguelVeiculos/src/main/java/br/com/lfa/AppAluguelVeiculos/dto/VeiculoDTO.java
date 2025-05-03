package br.com.lfa.AppAluguelVeiculos.dto;

import br.com.lfa.AppAluguelVeiculos.model.Veiculos;

public class VeiculoDTO {
	
	private Long id;
	private String modelo;
	private String marca;
	private String placa;
	private Boolean disponivel;
	private Integer ano;
	
	public VeiculoDTO() {}
	
	public VeiculoDTO(Veiculos veiculo) {
		this.id = veiculo.getId();
		this.modelo = veiculo.getModelo();
		this.marca = veiculo.getMarca();
		this.placa = veiculo.getPlaca();
		this.disponivel = veiculo.getDisponivel();
		this.ano = veiculo.getAno();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
