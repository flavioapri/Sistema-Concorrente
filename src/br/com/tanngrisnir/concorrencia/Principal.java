package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		int pedidos = 50;
		int quantidadeDeThreads = 3;

		BlockingQueue<Pedido> buffer = new GeradorDeBuffer(pedidos).gerar();

		InicializadorDeThreads inicializadorDeThreads = new InicializadorDeThreads(buffer);

		inicializadorDeThreads.inicializar(quantidadeDeThreads);

		Thread contador = new Thread(new ContadorDeTempoDeExecucao(buffer));

		contador.start();


	}
}
