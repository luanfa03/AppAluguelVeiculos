package br.com.lfa.AppAluguelVeiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_veiculos")
public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private Integer ano;
	
	@Column(nullable = false)
	private String placa;
	
	public Veiculos() {};
	
	public Veiculos(Long id, String modelo, String marca, Integer ano, String placa) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.placa = placa;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@Override
	public String toString() {
		String retorno = "[" + "Modelo: " + this.modelo + ", " + "Marca: " + this.marca + ", "
				+ "Ano: " + this.ano + ", " + "Placa: " + this.placa + "]";
		return retorno;
	}

}
