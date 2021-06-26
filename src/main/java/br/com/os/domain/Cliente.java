package br.com.os.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<OrdemServico> list = new ArrayList<>();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}

	public List<OrdemServico> getList() {
		return list;
	}

	public void setList(List<OrdemServico> list) {
		this.list = list;
	}

}
