package br.com.zuporange05.orangetalents05projetoproposta.cartoes;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
	Optional<Cartao> findByStatusCartao(StatusCartao statusCartao);
	Optional<Cartao> findByNumeroCartao(String numeroCartao);
	
}
