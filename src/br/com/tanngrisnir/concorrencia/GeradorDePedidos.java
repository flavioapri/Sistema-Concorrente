package br.com.tanngrisnir.concorrencia;

import java.util.Random;

public class GeradorDePedidos {

	private Random random;
	private final int dezDigitos = 1000000000;
	
	public GeradorDePedidos() {
		this.random = new Random();
	}

	public Pedido gerar() {
		Pedido pedido = new Pedido();
		pedido.setId(gerarId());
		
		return pedido;
	}

	private String gerarId() {
		String idDoPedido;
		Integer primeiraMetadeDoId;
		Integer segundaMetadeDoId;
		
		do {
			primeiraMetadeDoId = random.nextInt(Integer.MAX_VALUE);
			segundaMetadeDoId = random.nextInt(Integer.MAX_VALUE);
		} while (primeiraMetadeDoId < dezDigitos && segundaMetadeDoId < dezDigitos);

		idDoPedido = primeiraMetadeDoId.toString();
		idDoPedido += segundaMetadeDoId.toString();

		return idDoPedido;
	}

}
