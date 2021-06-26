package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.os.domain.Cliente;
 

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value=" SELECT c FROM Cliente c WHERE c.id =:id")
	Cliente findByid2(@Param("id") Long id);
}
