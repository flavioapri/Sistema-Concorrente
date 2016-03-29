package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Principal {
	public static int pedidos = 5000;
	public static int quantidadeDeThreads = 1;
	public static long tempoDeExecucao = 180000;
	public static long pedidosProcessados = 0;

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Pedido> buffer = new ArrayBlockingQueue<>(pedidos);

		new InicializadorDeThreads(buffer).inicializar();

		Thread timer = new Thread(new Timer());

		timer.start();
		
		while (true) {
			if (Thread.activeCount() == 1) {
				System.out.println("Pedidos processados: " + pedidosProcessados);
				break;
			} 
		}
	}
}