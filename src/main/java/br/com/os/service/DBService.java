package br.com.os.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.domain.Cliente;
import br.com.os.domain.OrdemServico;
import br.com.os.domain.Tecnico;
import br.com.os.enuns.Prioridade;
import br.com.os.enuns.Status;
import br.com.os.repository.ClienteRepository;
import br.com.os.repository.OrdemSerRepository;
import br.com.os.repository.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private OrdemSerRepository ordemSerRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;

	
	public void instaciaDB() {
/*
		Tecnico t1 = new Tecnico(null, "ze", "750.857.110-09", "7199999999");
		Cliente c = new Cliente(null, "ze", "750.857.110-09", "7199999999");
		OrdemServico o = new OrdemServico(null, "Sem obs", Prioridade.ALTA, Status.ABERTO, t1, c);

		t1.getList().add(o);
		c.getList().add(o);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c));
		ordemSerRepository.saveAll(Arrays.asList(o));
*/
	}

}
