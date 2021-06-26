package br.com.os.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.os.dto.osDto;
import br.com.os.service.osService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OsController {

	@Autowired
	private osService osS;

	@GetMapping(value = "/{id}")
	public ResponseEntity<osDto> findById(@PathVariable Long id) {
		osDto osdto = new osDto(osS.findById(id));
		return ResponseEntity.ok().body(osdto);
	}

	@GetMapping
	public ResponseEntity<List<osDto>> findAll() {
		List<osDto> list = osS.findAll().stream().map(objT -> new osDto(objT)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<osDto> create(@Valid @RequestBody osDto osdto) {
		osdto = new osDto(osS.create(osdto));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(osdto.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping 
	public ResponseEntity<osDto> update(@Valid @RequestBody osDto osdto) {
		osdto = new osDto(osS.update(osdto));

		return ResponseEntity.ok().body(osdto);
	}
	
	
	

}