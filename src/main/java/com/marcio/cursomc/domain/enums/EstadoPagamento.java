package com.marcio.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String description;
	
	private EstadoPagamento(int code, String description) {
		this.cod = code;
		this.description = description;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	//metodo que pode ser executado mesmo sem ter o objeto
	//instanciado
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		//percorre todos os possiveis atributos do enum
		for(EstadoPagamento x : EstadoPagamento.values()) {
			//caso o tipo informado exista, ele retorna
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
