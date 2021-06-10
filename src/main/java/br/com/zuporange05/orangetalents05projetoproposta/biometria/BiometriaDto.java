package br.com.zuporange05.orangetalents05projetoproposta.biometria;

import java.util.Base64;

import javax.validation.constraints.NotBlank;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;

public class BiometriaDto {
	
	@NotBlank
	private String fingerprint;

	@Deprecated
	public BiometriaDto() {
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public Biometria toBiometria(Cartao cartao, byte[] fingerprint) {

		String base64Biometria = Base64.getEncoder().encodeToString(fingerprint);
		return new Biometria(cartao, base64Biometria);
	}

}
