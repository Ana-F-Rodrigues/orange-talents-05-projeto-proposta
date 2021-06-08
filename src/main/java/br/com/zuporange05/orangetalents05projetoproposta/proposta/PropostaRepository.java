package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	Optional<Proposta> findByDocumento(String documento);
	
	@Query("select p from Proposta p where p.statusProposta = :status and p.cartao is null")
	List<Proposta> findByStatusOndeCartaoElegivel(StatusProposta status);
	
}
