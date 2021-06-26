package br.com.os.dto;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.os.domain.Tecnico;

public class TecnicoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message="O campo nome é obrigatório")
	//@NotNull(message = "Nome não pode ser nulo")
	private String nome;

	@CPF
	@Column(unique = true)
	@NotEmpty(message="O campo CPF é obrigatório")
	//@NotNull(message = "CPF não pode ser nulo")
	private String cpf;
	
	@NotEmpty(message="O campo Telefone é obrigatório")
	//@NotNull(message = "Telefone não pode ser nulo")
	private String telefone;

	public TecnicoDto() {
	}
	
	
	public TecnicoDto(TecnicoDto tecnicoDto) {
		super();

	}
	

	public TecnicoDto(Optional<Tecnico> tecnico) {
		super();
		this.id = tecnico.get().getId();
		this.nome = tecnico.get().getNome();
		this.cpf = tecnico.get().getCpf();
		this.telefone = tecnico.get().getTelefone();
	}

	public TecnicoDto(Tecnico tecnico) {
		super();
		this.id = tecnico.getId();
		this.nome = tecnico.getNome();
		this.cpf = tecnico.getCpf();
		this.telefone = tecnico.getTelefone();
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

}
