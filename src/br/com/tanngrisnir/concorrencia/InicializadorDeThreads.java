package br.com.tanngrisnir.concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class InicializadorDeThreads {
	private BlockingQueue<Pedido> buffer;
	private List<Thread> threadsProdutoras;
	private List<Thread> threadsConsumidoras;
	private int quantidadeDeThreads;
	private GeradorDePedidos geradorDePedidos;

	public InicializadorDeThreads(BlockingQueue<Pedido> buffer) {
		this.buffer = buffer;
		this.quantidadeDeThreads = Principal.quantidadeDeThreads;
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
