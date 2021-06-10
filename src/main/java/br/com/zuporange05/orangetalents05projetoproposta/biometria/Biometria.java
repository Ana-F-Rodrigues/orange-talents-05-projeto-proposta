package br.com.zuporange05.orangetalents05projetoproposta.biometria;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cartao cartao;

	@Lob
	private String fingerprint;

	@Deprecated
	public Biometria() {
	}

	public Biometria(Cartao cartao, String fingerprint) {

		this.cartao = cartao;
		this.fingerprint = fingerprint;
	}

	public Long getId() {
		return id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getFingerprint() {
		return fingerprint;
	}

}
