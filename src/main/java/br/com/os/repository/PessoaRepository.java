package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.os.domain.Pessoa;
import br.com.os.domain.Tecnico;

@Repository
@Transactional 
public interface PessoaRepository extends JpaRepository<Tecnico, Long> {
	
	@Query(value=" SELECT p FROM Pessoa p WHERE p.cpf =:cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);

}
