package br.com.tanngrisnir.concorrencia;

public class Pedido {

	private StringBuilder id;
	private StringBuilder dados;

	public Pedido(StringBuilder id, StringBuilder dados) {
		this.id = id;
		this.dados = dados;
	}

	@Override
	public String toString() {
		return "Identificador: " + id + " | Dados: " + dados;
	}
}
