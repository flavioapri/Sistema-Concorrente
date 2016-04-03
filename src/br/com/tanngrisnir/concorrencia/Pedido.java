package br.com.tanngrisnir.concorrencia;

/**
 * Representa um pedido. Um pedido deve atender as seguintes crit�rios: 1� Deve
 * possuir um identificador num�rico de 20 d�gitos. 2� Deve conter um pacote de
 * dados composto por 1000 caracteres.
 * 
 * @see GeradorDePedidos
 * @author Fl�vio Aparecido Ribeiro
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
