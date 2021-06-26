package br.com.os.dto;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import br.com.os.domain.Cliente;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "O campo nome é obrigatório")
	// @NotNull(message = "Nome não pode ser nulo")
	private String nome;

	@CPF
	@Column(unique = true)
	@NotEmpty(message = "O campo CPF é obrigatório")
	// @NotNull(message = "CPF não pode ser nulo")
	private String cpf;

	public ClienteDto() {
		super();
	}

	public ClienteDto(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
	}

	public ClienteDto(Optional<Cliente> cliente) {
		super();
		this.id = cliente.get().getId();
		this.nome = cliente.get().getNome();
		this.cpf = cliente.get().getCpf();
		this.telefone = cliente.get().getTelefone();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@NotEmpty(message = "O campo Telefone é obrigatório")
	// @NotNull(message = "Telefone não pode ser nulo")
	private String telefone;

}
