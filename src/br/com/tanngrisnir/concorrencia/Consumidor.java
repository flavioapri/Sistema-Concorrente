package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
	private BlockingQueue<Pedido> buffer;
	private int idThread;

	public Consumidor(BlockingQueue<Pedido> buffer, int i) {
		this.buffer = buffer;
		this.idThread = i;
	}

	@Override
	public void run() {

		while (!Timer.getTempoEsgotado()) {
			try {
				System.out.println("Thread consumidora " + idThread + " consumiu o pedido " + buffer.take());
				Principal.pedidosProcessados++;
			} catch (InterruptedException e) {
				System.out.println("Não foi possível consumir o pedido");
			}
		}
	}
}
