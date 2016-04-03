package br.com.tanngrisnir.concorrencia;

/**
 * Representa um pedido. Um pedido deve atender as seguintes critérios: 1º Deve
 * possuir um identificador numérico de 20 dígitos. 2º Deve conter um pacote de
 * dados composto por 1000 caracteres.
 * 
 * @see GeradorDePedidos
 * @author Flávio Aparecido Ribeiro
 *
 */
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
