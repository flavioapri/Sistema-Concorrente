package br.com.tanngrisnir.concorrencia;
import static br.com.tanngrisnir.concorrencia.Principal.*;

/**
 * Timer de tempo de execu��o na aplica��o. O tempo de execu��o desejado �
 * fornecido pela constante <i>tempoDeExecucao</i> na classe principal.
 * 
 * @author Fl�vio Aparecido Ribeiro
 */
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

			if (tempoTotal > TEMPO_DE_EXECUCAO) {
				tempoEsgotado = true;
				break;
			}
		}
	}
}
