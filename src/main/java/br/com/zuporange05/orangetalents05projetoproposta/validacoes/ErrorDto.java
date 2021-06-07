package br.com.zuporange05.orangetalents05projetoproposta.validacoes;

import java.util.Collection;

public class ErrorDto {
	
	private Collection<String> mensagens;

    public ErrorDto(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

}
