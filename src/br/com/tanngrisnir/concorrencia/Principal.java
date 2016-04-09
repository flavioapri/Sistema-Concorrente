package br.com.tanngrisnir.concorrencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Classe principal onde � executada a aplica��o. As vari�veis estaticas e final
 * da classe foram declaradas como tal por serem utilizadas para simplificar o
 * seu uso pelas classes da aplica��o, evitando a passagem de muitos param�tros
 * para construtores e m�todos destas. Estes valores s�o constantes final, uma
 * vez definidos n�o poderam ser alterados durante a execu��o da aplica��o, com
 * exe��o da vari�vel <i>pedidosProcessados</i> que � alterada a cada
 * processamento de um pedido. A classe tamb�m gera um log do processamento dos
 * pedidos e seu tempo de execu��o. Vale elencar tamb�m o uso da classe
 * <b>BlockingQueue</b> como o buffer que armazena os pedidos. Esta classe nos
 * permite acessar seus objetos de maneira sincronizada e ordenada sem a
 * necessidade de utlizarmos blocos de c�digo sincronizados e uso dos m�todos
 * <i>wait</i> e <i>notiffy</i> para tal, simplificando a aplica��o.
 * 
 * @author Fl�vio Aparecido Ribeiro
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