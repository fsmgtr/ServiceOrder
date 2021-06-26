package br.com.os.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.domain.Cliente;
import br.com.os.domain.OrdemServico;
import br.com.os.domain.Tecnico;
import br.com.os.dto.osDto;
import br.com.os.enuns.Prioridade;
import br.com.os.enuns.Status;
import br.com.os.exception.ObjectNotFoundException;
import br.com.os.repository.ClienteRepository;
import br.com.os.repository.OrdemSerRepository;
import br.com.os.repository.TecnicoRepository;

@Service
public class osService {

	@Autowired
	private OrdemSerRepository osRespository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Optional<OrdemServico> findById(Long id) {
		Optional<OrdemServico> os = osRespository.findById(id);
		return Optional.of(os.orElseThrow(() -> new ObjectNotFoundException("Os não encontrada não encontrado! "
				+ "Pode não está castrada no ID informado" + id + ", Tipo: " + Tecnico.class.getName())));
	}

	public List<OrdemServico> findAll() {
		return osRespository.findAll();
	}

	public OrdemServico create(osDto osdto) {
		return fromDto(osdto);
	}

	@SuppressWarnings("unused")
	private OrdemServico fromDto(osDto osdto) {
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setId(osdto.getId());
		ordemServico.setObservacoes(osdto.getObservacoes());
		ordemServico.setPrioridade(Prioridade.toEnum(osdto.getPrioridade()));
		ordemServico.setStatus(Status.toEnum(osdto.getStatus()));

		Tecnico tecnico = tecnicoRepository.findById(osdto.getTecnico()).get();
		 Cliente cliente = clienteRepository.findById(osdto.getCliente()).get();

		ordemServico.setCliente(cliente);
		ordemServico.setTecnico(tecnico);
		 
		
		if(ordemServico.getStatus().getCod().equals(2)) {
			ordemServico.setDataFechamento(LocalDateTime.now());
		}
		return osRespository.save(ordemServico);
	}

	public OrdemServico update(@Valid osDto osdto) {
		 findById(osdto.getId());
		return fromDto(osdto);
	}

}
