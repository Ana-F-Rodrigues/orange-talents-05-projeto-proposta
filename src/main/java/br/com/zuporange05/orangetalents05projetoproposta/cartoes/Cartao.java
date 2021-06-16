package br.com.zuporange05.orangetalents05projetoproposta.cartoes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.zuporange05.orangetalents05projetoproposta.biometria.Biometria;
import br.com.zuporange05.orangetalents05projetoproposta.bloqueio.BloqueioCartao;
import br.com.zuporange05.orangetalents05projetoproposta.carteira.Carteira;
import br.com.zuporange05.orangetalents05projetoproposta.proposta.Proposta;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String numeroCartao;

	private LocalDateTime emitidoEm = LocalDateTime.now();

	private String titular;

	private Integer limite;

	@OneToOne(mappedBy = "cartao")
	private Proposta proposta;
	
	@Enumerated(value = EnumType.STRING)
	private StatusCartao statusCartao = StatusCartao.ATIVO;
	
	 @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	 private List<Carteira> carteiras;

	@Deprecated
	public Cartao() {
	}

	public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, Integer limite, Proposta proposta) {

		this.numeroCartao = numeroCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.proposta = proposta;

	}

	public Long getId() {
		return id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public Integer getLimite() {
		return limite;
	}

	public Proposta getProposta() {
		return proposta;
	}
	

	public StatusCartao getStatusCartao() {
		return statusCartao;
	}
	
	public boolean bloqueado() {
		
		return this.statusCartao.equals(StatusCartao.BLOQUEADO);
		
	}
	
	public void adicionaBloqueio() {
        this.statusCartao = StatusCartao.BLOQUEADO;
    }
	
	public void adicionarCarteira(Carteira carteira) {
        this.carteiras.add(carteira);
    }

}
