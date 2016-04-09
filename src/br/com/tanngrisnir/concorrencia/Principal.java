package br.com.tanngrisnir.concorrencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Classe principal onde é executada a aplicação. As variáveis estaticas e final
 * da classe foram declaradas como tal por serem utilizadas para simplificar o
 * seu uso pelas classes da aplicação, evitando a passagem de muitos paramêtros
 * para construtores e métodos destas. Estes valores são constantes final, uma
 * vez definidos não poderam ser alterados durante a execução da aplicação, com
 * exeção da variável <i>pedidosProcessados</i> que é alterada a cada
 * processamento de um pedido. A classe também gera um log do processamento dos
 * pedidos e seu tempo de execução. Vale elencar também o uso da classe
 * <b>BlockingQueue</b> como o buffer que armazena os pedidos. Esta classe nos
 * permite acessar seus objetos de maneira sincronizada e ordenada sem a
 * necessidade de utlizarmos blocos de código sincronizados e uso dos métodos
 * <i>wait</i> e <i>notiffy</i> para tal, simplificando a aplicação.
 * 
 * @author Flávio Aparecido Ribeiro
 *
 */
public class Principal {
	static final int PEDIDOS = 5000;
	static final int QUANTIDADE_DE_THREADS = 10;
	static final long TEMPO_DE_EXECUCAO = 5000;
	static long pedidosProcessados = 0;
	static File log = new File("log.txt");
	static FileWriter impressorDeLog;

	public static void main(String[] args) throws InterruptedException, IOException {
		//TODO Criar classe para o log 
		impressorDeLog = new FileWriter(log);

		BlockingQueue<Pedido> buffer = new ArrayBlockingQueue<>(PEDIDOS);

		//Inicia o timer
		new Thread(new Timer()).start();

		new InicializadorDeThreads(buffer).inicializar();

		impressorDeLog.write("Total de pedidos processados: " + pedidosProcessados);
		System.out.println("Total de pedidos processados: " + pedidosProcessados);

		impressorDeLog.close();
	}
}