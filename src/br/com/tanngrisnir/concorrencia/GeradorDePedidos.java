package br.com.tanngrisnir.concorrencia;

import java.util.Random;

public class GeradorDePedidos {

	private Random random;
	private int numeroAleatorio;
	private final static int primeiroAlgarismoNaTabelaASCII = 33;
	private final static int ultimoAlgarismoNaTabelaASCII = 127;
	private final static int caracteresNoPacoteDeDados = 1000;
	private final static int digitosNoIdentificador = 20;

	public GeradorDePedidos() {
		this.random = new Random();
	}

	public Pedido gerar() {
		return new Pedido(gerarId(), gerarDados());
	}

	private StringBuilder gerarDados() {
		StringBuilder dados = new StringBuilder();

		while (dados.length() < caracteresNoPacoteDeDados) {
			numeroAleatorio = random.nextInt(ultimoAlgarismoNaTabelaASCII);

			if (numeroAleatorio < primeiroAlgarismoNaTabelaASCII) {
				continue;
			} else {
				dados.append((char) numeroAleatorio);
			}
		}
		return dados;
	}

	private StringBuilder gerarId() {
		StringBuilder id = new StringBuilder();

		while (id.length() < digitosNoIdentificador) {
			numeroAleatorio = random.nextInt(10);
			id.append(numeroAleatorio);
		}
		return id;
	}
}
