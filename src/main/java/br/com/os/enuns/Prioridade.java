package br.com.os.enuns;

public enum Prioridade {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer cod;
	private String descricao;

	private Prioridade(Integer cod, String descricao) {
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
	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		// para cada objeto p no caso x pegando os valores
		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade não invalida" + cod);
	}

}
