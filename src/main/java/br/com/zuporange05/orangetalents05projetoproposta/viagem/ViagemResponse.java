package br.com.zuporange05.orangetalents05projetoproposta.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ViagemResponse {
	
	private String destino;
	private LocalDateTime dataTermino;
	
	
	
	
	public ViagemResponse(String destino, LocalDateTime dataTermino) {

		this.destino = destino;
		this.dataTermino = dataTermino;
	
		
	}
	
	public String getDestino() {
		return destino;
	}
	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	
	

}
