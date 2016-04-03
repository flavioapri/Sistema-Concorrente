package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

/**
 * Produtor que gera pedidos e os insere no bufer. A classe implementa
 * <u>Runnable</u> para que possa ser executada como uma thread.
 * 
 * @author Flávio Aparecido Ribeiro
 *
 */
public class Produtor implements Runnable {
	private int idThread;
	private BlockingQueue<Pedido> buffer;
	private GeradorDePedidos geradorDePedidos;

	public Produtor(BlockingQueue<Pedido> buffer, int i, GeradorDePedidos geradorDePedidos) {
		this.buffer = buffer;
		this.idThread = i;
		this.geradorDePedidos = geradorDePedidos;
	}

	@Override
	public void run() {
		// Enquanto o timer não esgotar o tempo
		while (!Timer.getTempoEsgotado()) {
			Pedido pedido = geradorDePedidos.gerar();
			System.out.println("Thread produtora " + idThread + " produziu o pedido " + pedido);

			try {
				buffer.add(pedido);
			} catch (IllegalStateException e) {
				System.out.println("Não é possível inserir o pedido. Buffer cheio.");
			}
		}
	}
}
