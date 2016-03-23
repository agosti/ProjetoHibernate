package br.edu.unoesc.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum TipoEndereco {

	COMERCIAL("comercial"),
	RESIDENCIAL("residencial"),
	CONTATO("contato");
	
	private String descricao;
	
}
