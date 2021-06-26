package br.com.os.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.domain.Pessoa;
import br.com.os.domain.Tecnico;
import br.com.os.dto.TecnicoDto;
import br.com.os.exception.DetaIntegratyViolantionException;
import br.com.os.exception.ObjectNotFoundException;
import br.com.os.repository.PessoaRepository;
import br.com.os.repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Optional<Tecnico> findById(Long id) {
		Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
		return Optional.of(tecnico.orElseThrow(() -> new ObjectNotFoundException("Técnico não encontrado! "
				+ "Pode não está castrado para o ID informado" + id + ", Tipo: " + Tecnico.class.getName())));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}

	public Tecnico create(TecnicoDto tecnicoDto) {
		if (findByCPF(tecnicoDto) != null) {
			throw new DetaIntegratyViolantionException("Cpf já cadastrado");
		}

		Tecnico tecnico = new Tecnico(null, tecnicoDto.getNome(), tecnicoDto.getCpf(), tecnicoDto.getTelefone());

		return tecnicoRepository.save(tecnico);

	}

	public Tecnico update(Long id, @Valid TecnicoDto tecnicoDto) {
		Optional<Tecnico> oldTecnico = findById(id);

		if (findByCPF(tecnicoDto) != null && findByCPF(tecnicoDto).getId() != id) {
			throw new DetaIntegratyViolantionException("  este não é o seu CPF!");
		}

		oldTecnico.get().setNome(tecnicoDto.getNome());
		oldTecnico.get().setCpf(tecnicoDto.getCpf());
		oldTecnico.get().setTelefone(tecnicoDto.getTelefone());

		return tecnicoRepository.save(oldTecnico.get());

	}

	private Pessoa findByCPF(TecnicoDto tecnicoDto) {
		Pessoa tecnico = pessoaRepository.findByCPF(tecnicoDto.getCpf());

		if (tecnico != null) {
			return tecnico;
		}
		return null;

	}

	public void deleteById(Long id) {
		Optional<Tecnico> tecnico = findById(id);
		if (tecnico.get().getList().size() > 0) {
			throw new DetaIntegratyViolantionException("Técnico possuiu ordens de serviços não pode ser deletado.");
		}
		tecnicoRepository.deleteById(id);

	}

}
