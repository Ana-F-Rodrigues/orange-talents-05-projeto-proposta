package br.com.zuporange05.orangetalents05projetoproposta.carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraRequest {
	
	@Email
    @NotBlank
    private String email;

    private String carteira;

    public CarteiraRequest(@Email @NotBlank String email, String carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getCarteira() {
        return carteira;
    }

    public CarteiraEnum getCarteiraEnum() {
        return CarteiraEnum.valueOf(carteira);
    }
}

