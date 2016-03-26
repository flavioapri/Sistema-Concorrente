package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Testa {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Pedido> buffer = new GeradorDeBuffer(5000).gerar();
		
		Thread thread = new Thread(new Consumidor(buffer));
		
		thread.start();
		
	}
}
