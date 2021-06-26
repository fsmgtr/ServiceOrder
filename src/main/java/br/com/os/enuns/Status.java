package br.com.os.enuns;

public enum Status {
	ABERTO(0, "ABERTO"), ANADAMENTO(1, "ANADAMENTO"), FECHADO(2, "FECHADO");

	private Integer cod;
	private String descricao;

	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	/*
	 * Static para não ser necessário instaciar uma nova prioridade para chamar o
	 * método
	 */
	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		// para cada objeto p no caso x pegando os valores
		for (Status x : Status.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido" + cod);
	}

}
