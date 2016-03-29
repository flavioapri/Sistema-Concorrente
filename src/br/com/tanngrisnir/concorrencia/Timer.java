package br.com.tanngrisnir.concorrencia;

public class Timer implements Runnable {
	private long tempoInicial;
	private long tempoFinal;
	private long tempoTotal;
	private static boolean tempoEsgotado;

	public Timer() {
		Timer.tempoEsgotado = false;
	}
	
	public static boolean getTempoEsgotado() {
		return tempoEsgotado;
	}

	@Override
	public void run() {
		tempoInicial = System.currentTimeMillis();

		while (!tempoEsgotado) {
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal - tempoInicial;

			if (tempoTotal > Principal.tempoDeExecucao) {
				tempoEsgotado = true;
				break;
			}
		}
	}
}
