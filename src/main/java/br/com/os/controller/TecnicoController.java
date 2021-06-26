package br.com.os.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import br.com.os.domain.Tecnico;
import br.com.os.dto.TecnicoDto;
import br.com.os.service.TecnicoService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoService tService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDto> findById(@PathVariable Long id) {
		Optional<Tecnico> tecnico = tService.findById(id);
		TecnicoDto tecnicoDto = new TecnicoDto(tecnico);
		return ResponseEntity.ok().body(tecnicoDto);
	}

	@GetMapping
	public ResponseEntity<List<TecnicoDto>> findAll() {
		List<TecnicoDto> listDto = tService.findAll().stream().map(objT -> new TecnicoDto(objT))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@PostMapping
	public ResponseEntity<TecnicoDto> create(@Valid @RequestBody TecnicoDto tecnicoDto) {
		Tecnico tecnico = tService.create(tecnicoDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDto> update(@PathVariable Long id, @Valid @RequestBody TecnicoDto tecnicoDto) {
		TecnicoDto newTecnicoDto = new TecnicoDto(tService.update(id, tecnicoDto));

		return ResponseEntity.ok().body(newTecnicoDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tService.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
