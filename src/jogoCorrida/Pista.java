package jogoCorrida;

public class Pista {
	private int distanciaMax;
	private boolean jogoAtivo;

	private Carro car1 = new Carro();
	private Carro car2 = new Carro();

	public Pista(int distanciaMax) {
		this.jogoAtivo = true;
		this.distanciaMax = distanciaMax;
	}

	public String gerarEspacos(int distanciaPercorrida) {
		String espacos = " ".repeat(distanciaPercorrida - 1);
		return espacos;
	}

	public String desenharPista() {
		String linha = "-".repeat(distanciaMax) + "\n";

		return linha + car1.desenharCarro(this) + car2.desenharCarro(this) + linha;
	}

	public void pausar() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("A pausa foi interrompida!");
			e.printStackTrace();
		}
	}

	public void corrida() {

		while (jogoAtivo) {

			pausar();

			System.out.println("Vez do jogador " + car1.getNomePlayer() + ":");
			car1.sorteioVelocidade();

			System.out.println("O jogador " + car1.getNomePlayer() + " tirou " + car1.getVelocidade());
			car1.atualizarDistancia();

			System.out.println(" ");

			pausar();

			if (car1.getDistanciaPercorrida() > this.distanciaMax
					|| car2.getDistanciaPercorrida() > this.distanciaMax) {
				this.jogoAtivo = false;
			}

			System.out.println("Vez do jogador " + car2.getNomePlayer() + ":");
			car2.sorteioVelocidade();

			System.out.println("O jogador " + car2.getNomePlayer() + " tirou " + car2.getVelocidade());
			car2.atualizarDistancia();

			if (car1.getDistanciaPercorrida() >= this.distanciaMax
					|| car2.getDistanciaPercorrida() >= this.distanciaMax) {
				this.jogoAtivo = false;
			}

			System.out.println(" ");

			System.out.println(desenharPista());

		}

		if (car1.getDistanciaPercorrida() > car2.getDistanciaPercorrida()) {
			System.out.println("O vencedor é o jogador: " + car1.getNomePlayer() + "!!");
			System.out.println(
					"O jogador " + car1.getNomePlayer() + " chegou à distância: " + car1.getDistanciaPercorrida());
			System.out.println(
					"O jogador " + car2.getNomePlayer() + " chegou à distância: " + car2.getDistanciaPercorrida());
		} else if (car2.getDistanciaPercorrida() > car1.getDistanciaPercorrida()) {
			System.out.println("O vencedor é o jogador: " + car2.getNomePlayer() + "!!");
			System.out.println(
					"O jogador " + car1.getNomePlayer() + " chegou à distância: " + car1.getDistanciaPercorrida());
			System.out.println(
					"O jogador " + car2.getNomePlayer() + " chegou à distância: " + car2.getDistanciaPercorrida());
		} else {
			System.out.println("Empate! Ambos os jogadores chegaram à mesma distância.");
			System.out.println("Os jogadores chegaram à distância: " + car1.getDistanciaPercorrida());

		}

	}

	public Carro getCar1() {
		return car1;
	}

	public void setCar1(Carro car1) {
		this.car1 = car1;
	}

	public Carro getCar2() {
		return car2;
	}

	public void setCar2(Carro car2) {
		this.car2 = car2;
	}

}
