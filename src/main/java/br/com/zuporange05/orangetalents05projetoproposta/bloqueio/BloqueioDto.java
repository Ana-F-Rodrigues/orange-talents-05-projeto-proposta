package br.com.zuporange05.orangetalents05projetoproposta.bloqueio;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;

public class BloqueioDto {
	
	@NotBlank
	private String sistemaResponsavel;
	
	
	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public BloqueioDto(String request) {
        this.sistemaResponsavel = request;
    }

	public BloqueioCartao toModel(String ipSolicitante, String userAgent,
			Cartao cartao) {
		
        return new BloqueioCartao(ipSolicitante, userAgent, cartao);
        
        
        
    }

}
