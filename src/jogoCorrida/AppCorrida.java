package jogoCorrida;

import java.util.Scanner;

public class AppCorrida {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Defina a distancia Maxíma da corrida: ");

		Pista pista = new Pista(sc.nextInt());

		sc.nextLine();

		System.out.println("Digite o nome do jogador 1: ");
		pista.getCar1().setNomePlayer(sc.nextLine());

		System.out.println("Digite o nome do jogador 2: ");
		pista.getCar2().setNomePlayer(sc.nextLine());

		pista.corrida();
		sc.close();
	}

}
