package br.com.os.domain;

 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<OrdemServico> list = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
	}

	public List<OrdemServico> getList() {
		return list;
	}

	public void setList(List<OrdemServico> list) {
		this.list = list;
	}

}
