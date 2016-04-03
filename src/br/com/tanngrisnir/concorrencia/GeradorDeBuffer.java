package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Classe que gera o buffer populado pela quantidade informada de pedidos.
 * 
 * @author Flávio Aparecido Ribeiro
 *
 */
public class GeradorDeBuffer {

	private GeradorDePedidos geradorDePedidos;
	private int quantidadeDePedidos;

	public GeradorDeBuffer(int quantidadeDePedidos) {
		this.geradorDePedidos = new GeradorDePedidos();
		this.quantidadeDePedidos = quantidadeDePedidos;
	}

	public BlockingQueue<Pedido> gerar() {
		BlockingQueue<Pedido> buffer = new ArrayBlockingQueue<>(quantidadeDePedidos);

		for (int i = 0; i < quantidadeDePedidos; i++) {
			try {
				buffer.put(geradorDePedidos.gerar());
			} catch (InterruptedException e) {
				System.out.println("Não foi possível gerar o pedido");
			}
		}
		return buffer;
	}

}
