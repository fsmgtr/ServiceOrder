package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.os.domain.Tecnico;

@Repository
@Transactional
 
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	@Query(value=" SELECT t FROM Tecnico t WHERE t.cpf =:cpf")
	Tecnico findByCPF(@Param("cpf") String cpf);

}
