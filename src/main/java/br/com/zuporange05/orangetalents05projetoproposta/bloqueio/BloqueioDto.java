package br.com.zuporange05.orangetalents05projetoproposta.bloqueio;

import javax.validation.constraints.NotBlank;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;

public class BloqueioDto {
	
	@NotBlank
	private String sistemaResponsavel;
	
	
	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	
	public BloqueioDto(BloqueioDto request) {
        this.sistemaResponsavel = request.getSistemaResponsavel();
    }

	public BloqueioCartao toModel(String ipSolicitante, String userAgent,
			Cartao cartao) {
		
        return new BloqueioCartao(ipSolicitante, userAgent, cartao);
        
        
        
    }

}
