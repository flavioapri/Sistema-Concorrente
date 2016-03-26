package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

	private BlockingQueue<Pedido> buffer;

	public Consumidor(BlockingQueue<Pedido> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		
		while (!buffer.isEmpty()) {
			try {
				System.out.println("Consumindo pedido " + buffer.take());
			} catch (InterruptedException e) {
				System.out.println("N�o foi poss�vel consumir o pedido");
			} 
		}
	}

}
