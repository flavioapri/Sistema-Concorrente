package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class Principal {
	public static volatile int executadas = 0;
	public static int pedidos = 5000;
	public static int quantidadeDeThreads = 1;

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Pedido> buffer = new GeradorDeBuffer(pedidos).gerar();

		InicializadorDeThreads inicializadorDeThreads = new InicializadorDeThreads(buffer);

		ContadorDeTempoDeExecucao contadorDeTempoDeExecucao = new ContadorDeTempoDeExecucao();

		Thread contador = new Thread(contadorDeTempoDeExecucao);

		contador.start();

		inicializadorDeThreads.inicializar(quantidadeDeThreads);

	}
}
