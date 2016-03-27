package br.com.tanngrisnir.concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class InicializadorDeThreads {

	private BlockingQueue<Pedido> buffer;
	private List<Thread> threads;

	public InicializadorDeThreads(BlockingQueue<Pedido> buffer) {
		this.buffer = buffer;
	}

	public void inicializar(int quantidadeDeThreads) {
		threads = new ArrayList<>(quantidadeDeThreads);

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threads.add(new Thread(new Consumidor(buffer, i)));
		}

		for (int i = 0; i < quantidadeDeThreads; i++) {
			threads.get(i).start();
		}

	}

}
