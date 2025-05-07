package jogoCorrida;

import java.util.Random;

public class Carro {
	private String nomePlayer;
	private int distanciaPercorrida;
	private int velocidade;

	public Carro() {
		this.distanciaPercorrida = 0;
		this.velocidade = 0;
	}

	public int sorteioVelocidade() {
		Random rand = new Random();
		this.velocidade = (rand.nextInt(3) + 1);
		return this.velocidade;
	}

	public int atualizarDistancia() {
		this.distanciaPercorrida += this.velocidade;
		return this.distanciaPercorrida;
	}

	public String desenharCarro(Pista pista) {
		return pista.gerarEspacos(distanciaPercorrida) + "#\n";

	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public String getNomePlayer() {
		return nomePlayer;
	}

	public void setNomePlayer(String nomePlayer) {
		this.nomePlayer = nomePlayer;
	}

}

