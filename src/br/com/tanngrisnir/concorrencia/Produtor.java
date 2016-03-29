package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

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

		while (!Timer.getTempoEsgotado()) {
			Pedido pedido = geradorDePedidos.gerar();
			System.out.println("Thread produtora " + idThread + " produziu o pedido " + pedido);
			buffer.add(pedido);
		}
	}
}
