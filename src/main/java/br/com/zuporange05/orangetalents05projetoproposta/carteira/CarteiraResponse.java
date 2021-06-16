package br.com.zuporange05.orangetalents05projetoproposta.carteira;

public class CarteiraResponse {
	
	    private String resultado;
	    private String id;

	    public CarteiraResponse(String resultado, String id) {
	        this.resultado = resultado;
	        this.id = id;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getResultado() {
	        return resultado;
	    }

}
