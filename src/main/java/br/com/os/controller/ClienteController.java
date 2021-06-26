package br.com.os.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.os.domain.Cliente;
import br.com.os.dto.ClienteDto;
import br.com.os.service.ClienteService;
@CrossOrigin("*")
@RestController
@Transactional
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		ClienteDto clienteDto = new ClienteDto(cliente);
		return ResponseEntity.ok().body(clienteDto);
	}

	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll() {
		List<ClienteDto> listDto = clienteService.findAll().stream().map(objT -> new ClienteDto(objT))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping
	public ResponseEntity<ClienteDto> create(@Valid @RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.create(clienteDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable Long id, @Valid @RequestBody ClienteDto clienteDto) {
		ClienteDto newClientedto = new ClienteDto(clienteService.update(id, clienteDto));

		return ResponseEntity.ok().body(newClientedto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
