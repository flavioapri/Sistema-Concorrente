package br.com.tanngrisnir.concorrencia;

import java.util.concurrent.BlockingQueue;

public class ContadorDeTempoDeExecucao implements Runnable {
	private long tempoInicial;
	private long tempoFinal;
	private long tempoTotal;
	private BlockingQueue<Pedido> buffer;
	private boolean executou;

	public ContadorDeTempoDeExecucao(BlockingQueue<Pedido> buffer) {
		this.buffer = buffer;
		this.executou = false;
	}

	@Override
	public void run() {
		tempoInicial = System.currentTimeMillis();

		while (!executou) {
			if (buffer.isEmpty()) {
				tempoFinal = System.currentTimeMillis();
				tempoTotal = tempoFinal - tempoInicial;
				executou = true;

				System.out.println("Tempo total de processamento " + tempoTotal + " ms");
			}
		}

	}

}
