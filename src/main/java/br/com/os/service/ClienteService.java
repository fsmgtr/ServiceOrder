package br.com.os.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.os.domain.Cliente;
import br.com.os.domain.Pessoa;
import br.com.os.dto.ClienteDto;
import br.com.os.exception.DetaIntegratyViolantionException;
import br.com.os.exception.ObjectNotFoundException;
import br.com.os.repository.ClienteRepository;
import br.com.os.repository.PessoaRepository;
import br.com.os.repository.TecnicoRepository;

@Service
public class ClienteService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	private Pessoa findByCPF(ClienteDto clienteDto) {
		Pessoa tecnico = pessoaRepository.findByCPF(clienteDto.getCpf());

		if (tecnico != null) {
			return tecnico;
		}
		return null;

	}

	public Cliente create(ClienteDto clienteDto) {
		if (findByCPF(clienteDto) != null) {
			throw new DetaIntegratyViolantionException("Cpf já cadastrado");
		}
		Cliente cliente = new Cliente(null, clienteDto.getNome(), clienteDto.getCpf(), clienteDto.getTelefone());
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return Optional.of(cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! "
				+ "Pode não está castrado para o ID informado" + id + ", Tipo: " + Cliente.class.getName())));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente update(Long id, @Valid ClienteDto clienteDto) {
		Optional<Cliente> oldCliente = findById(id);

		if (findByCPF(clienteDto) != null && findByCPF(clienteDto).getId() != id) {
			throw new DetaIntegratyViolantionException("  este não é o seu CPF!");
		}

		oldCliente.get().setNome(clienteDto.getNome());
		oldCliente.get().setCpf(clienteDto.getCpf());
		oldCliente.get().setTelefone(clienteDto.getTelefone());

		return clienteRepository.save(oldCliente.get());

	}

	public void deleteById(Long id) {
		Optional<Cliente> cliente = findById(id);
		if (cliente.get().getList().size() > 0) {
			throw new DetaIntegratyViolantionException("Técnico possuiu ordens de serviços não pode ser deletado.");
		}
		tecnicoRepository.deleteById(id);

	}

}
