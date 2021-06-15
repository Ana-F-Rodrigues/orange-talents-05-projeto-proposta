package br.com.zuporange05.orangetalents05projetoproposta.viagem;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;



public class ViagemRequest {
	
	@NotBlank
	private String destino;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate dataTermino;

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}
	

}
