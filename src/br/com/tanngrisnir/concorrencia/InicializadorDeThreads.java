package br.com.tanngrisnir.concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import static br.com.tanngrisnir.concorrencia.Principal.*;


/**
 * Inicializa todas as threads necessárias para a execução da aplicação. Com ela
 * retiramos a responsabilidade da classe <b>Principal</b> realizar esta tarefa
 * separando esta lógica e simplificando a classe <b>Principal</b>.
 * 
 * @author Flávio Aparecido Ribeiro
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

			// O método join é utilizado para que o fluxo de execução da classe
			// chamadora (no caso a classe principal) só continue no ponto que
			// parou após todas estas threads terminarem sua execução. Isso é
			// necessário para que o tempo de execução seja impresso somente
			// após todas as threds terminarem. Do contrário exibira antes.
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
