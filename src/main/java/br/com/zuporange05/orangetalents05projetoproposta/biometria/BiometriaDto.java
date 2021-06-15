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

	public Biometria toBiometria(Cartao cartao) {

		return new Biometria(cartao, fingerprint);
	}

	public boolean biometriaValida() {
		
	
	
		 try{
			 Base64.getDecoder().decode(fingerprint);
			 return true;
			}
		 catch(IllegalArgumentException e) {
			 
		 return false;
		 }
		 
	}
	
}
