package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.os.domain.Cliente;
 

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
