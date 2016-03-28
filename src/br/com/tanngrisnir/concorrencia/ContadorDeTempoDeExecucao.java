package br.com.tanngrisnir.concorrencia;

public class ContadorDeTempoDeExecucao implements Runnable {
	private long tempoInicial;
	private long tempoFinal;
	private long tempoTotal;
	private boolean executou;

	public ContadorDeTempoDeExecucao() {
		this.executou = false;
	}

	public long getTempoTotal() {
		return this.tempoTotal;
	}

	@Override
	public void run() {
		tempoInicial = System.currentTimeMillis();

		while (!executou) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}

			if (Principal.executadas == Principal.quantidadeDeThreads) {
				tempoFinal = System.currentTimeMillis();
				tempoTotal = tempoFinal - tempoInicial;
				executou = true;
				System.out.println("Tempo total " + tempoTotal + " ms");
			}
		}

	}

}
