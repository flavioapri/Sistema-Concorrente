package br.com.tanngrisnir.concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import static br.com.tanngrisnir.concorrencia.Principal.*;


/**
 * Inicializa todas as threads necess�rias para a execu��o da aplica��o. Com ela
 * retiramos a responsabilidade da classe <b>Principal</b> realizar esta tarefa
 * separando esta l�gica e simplificando a classe <b>Principal</b>.
 * 
 * @author Fl�vio Aparecido Ribeiro
 *
 */
public class InicializadorDeThreads {
	private BlockingQueue<Pedido> buffer;
	private List<Thread> threadsProdutoras;
	private List<Thread> threadsConsumidoras;
	private int quantidadeDeThreads;
	private GeradorDePedidos geradorDePedidos;

	public InicializadorDeThreads(BlockingQueue<Pedido> buffer) {
		this.buffer = buffer;
		this.quantidadeDeThreads = QUANTIDADE_DE_THREADS;
		this.geradorDePedidos = new GeradorDePedidos();
	}

	public void inicializar() {
		inicializarProdutoras();
		inicializarConsumidoras();
	}

	private void inicializarConsumidoras() {
		threadsConsumidoras = new ArrayList<>(quantidadeDeThreads);

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threadsConsumidoras.add(new Thread(new Consumidor(buffer, i)));
		}

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threadsConsumidoras.get(i).start();

			// O m�todo join � utilizado para que o fluxo de execu��o da classe
			// chamadora (no caso a classe principal) s� continue no ponto que
			// parou ap�s todas estas threads terminarem sua execu��o. Isso �
			// necess�rio para que o tempo de execu��o seja impresso somente
			// ap�s todas as threds terminarem. Do contr�rio exibira antes.
			try {
				threadsConsumidoras.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void inicializarProdutoras() {
		threadsProdutoras = new ArrayList<>(quantidadeDeThreads);

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threadsProdutoras.add(new Thread(new Produtor(buffer, i, geradorDePedidos)));
		}

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threadsProdutoras.get(i).start();
		}
	}
}
