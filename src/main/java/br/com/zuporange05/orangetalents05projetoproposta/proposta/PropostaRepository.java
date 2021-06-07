package br.com.zuporange05.orangetalents05projetoproposta.proposta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {
	Optional<Proposta> findByDocumento(String documento);
}
