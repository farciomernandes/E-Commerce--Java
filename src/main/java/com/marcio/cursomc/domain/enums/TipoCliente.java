package com.marcio.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String description;
	
	private TipoCliente(int code, String description) {
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
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		//percorre todos os possiveis atributos do enum
		for(TipoCliente x : TipoCliente.values()) {
			//caso o tipo informado exista, ele retorna
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}
}
