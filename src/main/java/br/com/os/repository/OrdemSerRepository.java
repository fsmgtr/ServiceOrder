package br.com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
import br.com.os.domain.OrdemServico;

@Repository
@Transactional
public interface OrdemSerRepository extends JpaRepository<OrdemServico, Long> {

}
