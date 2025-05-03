package br.com.lfa.AppAluguelVeiculos.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lfa.AppAluguelVeiculos.model.Cliente;

public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	public ClienteDTO() {}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.dataNascimento = cliente.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
