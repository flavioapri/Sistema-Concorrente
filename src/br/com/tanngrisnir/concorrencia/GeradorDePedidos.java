package br.com.tanngrisnir.concorrencia;

import java.util.Random;

/**
 * Gera pedidos com dados aleatórios. A classe gera as informações dos pedidos
 * utilizando <b>StringBuilder</b> para ganhar em performance na geração destas
 * informações. Seu uso plausível para a aplicação porque seram geradas muitas
 * strings durante a execução do processamento de todos os pedidos. Foram usadas
 * as constantes que fazem referência a tabela ASCII porque estas representam o
 * intervalo na tabela ASCII de caracteres que pode ser impressos na codificação
 * Java. A tabela possui muitos caracteres que não podem ser impressos em Java.
 * Para entender o motivo do uso das constantes na classe veja a classe
 * <b>Pedido</b>. Veja a tabela ASCII: http://www.asciitable.com/
 * 
 * @see Pedido
 * @author Flávio Aparecido Ribeiro
 *
 */
public class GeradorDePedidos {
	private Random random;
	private int numeroAleatorio;
	private final static int PRIMEIRO_IMPRIMIVEL_DA_TABELA_ASCII = 33;
	private final static int ULTIMO_IMPRIMIVEL_NA_TABELA_ASCII = 127;
	private final static int CARACTERES_NO_PACOTE_DE_DADOS = 1000;
	private final static int DIGITOS_NO_IDENTIFICADOR = 20;

	public GeradorDePedidos() {
		this.random = new Random();
	}

	public Pedido gerar() {
		return new Pedido(gerarId(), gerarDados());
	}

	/**
	 * Gera uma string aleatória de mil caracteres.
	 * 
	 * @return Uma string de mil caracteres aleatórios
	 */
	private StringBuilder gerarDados() {
		StringBuilder dados = new StringBuilder();

		// Enquanto a string dos dados não a quantidade de caracteres do pacote
		// de dados...
		while (dados.length() < CARACTERES_NO_PACOTE_DE_DADOS) {
			// Gera um número aleatório até o que representa o último caractere
			// que pode ser impresso na tabela ASCII
			numeroAleatorio = random.nextInt(ULTIMO_IMPRIMIVEL_NA_TABELA_ASCII);
			if (numeroAleatorio < PRIMEIRO_IMPRIMIVEL_DA_TABELA_ASCII) {
				// Se o número gerado for menor que o que representa primeiro
				// que pode ser impresso na tabela ASCII continua no laço
				continue;
			} else {
				// Converte o número no respectivo caractere da tabela ASCII e
				// adiciona a string
				dados.append((char) numeroAleatorio);
			}
		}
		return dados;
	}

	/**
	 * Gera uma string aleatória de 20 dígitos.
	 * 
	 * @return Uma string aleatória de 20 dígitos.
	 */
	private StringBuilder gerarId() {
		StringBuilder id = new StringBuilder();

		// Segue a mesma lógica do método que gera os dados mas converte os
		// números para os respectivos na tabela ASCII
		while (id.length() < DIGITOS_NO_IDENTIFICADOR) {
			numeroAleatorio = random.nextInt(10);
			id.append(numeroAleatorio);
		}
		return id;
	}
}
