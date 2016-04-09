package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;
import static br.com.tanngrisnir.concorrencia.Principal.*;

/**
 * Consumidor de pedidos gerados. Remove um pedido do buffer. A classe
 * implementa <u>Runnable</u> para que possa ser executada como uma thread.
 * 
 * @author Flávio Aparecido Ribeiro
 *
 */
public class Consumidor implements Runnable {
	private int idThread;
	private BlockingQueue<Pedido> buffer;

	public Consumidor(BlockingQueue<Pedido> buffer, int i) {
		this.buffer = buffer;
		this.idThread = i;
	}

	@Override
	public void run() {
		// Enquanto o timer não esgotar o tempo...
		while (!Timer.getTempoEsgotado()) {
			try {
				// Remove um pedido do buffer
				System.out.println("Thread consumidora " + idThread + " consumiu o pedido " + buffer.take());
				pedidosProcessados++;
			} catch (InterruptedException e) {
				System.out.println("Não foi possível consumir o pedido");
			}
		}
	}
}
