package br.com.zuporange05.orangetalents05projetoproposta.carteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zuporange05.orangetalents05projetoproposta.cartoes.Cartao;

@Entity
public class Carteira {
	
    	@Id
	    @NotBlank
	    private String id;

	    @Email
	    @NotBlank
	    private String email;

	    @Enumerated(EnumType.STRING)
	    @NotNull
	    private CarteiraEnum carteira;

	    @ManyToOne
	    private Cartao cartao;

	    @Deprecated
	    public Carteira() {
	    }

	    public Carteira(@NotBlank String id, @Email @NotBlank String email, @NotNull CarteiraEnum carteira, Cartao cartao) {
	        this.id = id;
	        this.email = email;
	        this.carteira = carteira;
	        this.cartao = cartao;
	    }

}


