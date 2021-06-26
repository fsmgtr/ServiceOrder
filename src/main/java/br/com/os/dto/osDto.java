package br.com.os.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.os.domain.OrdemServico;

public class osDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	@NotEmpty(message="O campo Obs é obrigatório")
	private String observacoes;
	private Integer prioridade;
	private Integer status;
	 
	private Long tecnico;
	 
	private Long cliente;

	private Long id;

	 
	
	public osDto(Optional<OrdemServico> os) {
		super();
		this.id = os.get().getId();
		this.dataAbertura = os.get().getDataAbertura();
		this.dataFechamento = os.get().getDataFechamento();
		this.observacoes = os.get().getObservacoes();
		this.prioridade = os.get().getPrioridade().getCod();
		this.status = os.get().getStatus().getCod();
		this.tecnico = os.get().getTecnico().getId();
		this.cliente = os.get().getCliente().getId();
	}
	
	
	public osDto(OrdemServico os) {
		super();
		this.id = os.getId();
		this.dataAbertura = os.getDataAbertura();
		this.dataFechamento = os.getDataFechamento();
		this.observacoes = os.getObservacoes();
		this.prioridade = os.getPrioridade().getCod();
		this.status = os.getStatus().getCod();
		this.tecnico = os.getTecnico().getId();
		this.cliente = os.getCliente().getId();
	}
	

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTecnico() {
		return tecnico;
	}

	public void setTecnico(Long tecnico) {
		this.tecnico = tecnico;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
