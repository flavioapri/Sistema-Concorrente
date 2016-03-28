package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

	private BlockingQueue<Pedido> buffer;
	private int idThread;

	public Consumidor(BlockingQueue<Pedido> buffer, int idThread) {
		this.buffer = buffer;
		this.idThread = idThread;
	}

	@Override
	public void run() {

		while (!buffer.isEmpty()) {
			try {
				System.out.println("Thread " + idThread + " consumindo pedido " + buffer.take());
			} catch (InterruptedException e) {
				System.out.println("Não foi possível consumir o pedido");
			}
		}

		Principal.executadas++;
	}

}
