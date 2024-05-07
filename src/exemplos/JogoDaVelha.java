package exemplos;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {

		char[][] tabuleiro = new char[3][3];
		char jogadorAtual = 'X';
		jogar(jogadorAtual, tabuleiro);

	}

	private static void jogar(char jogadorAtual, char[][] tabuleiro) {

		Scanner leia = new Scanner(System.in);
		inicializarTabuleiro(tabuleiro);
		boolean jogoRolando = true;

		while (jogoRolando == true) {
			mostrarTabuleiro(tabuleiro);
			System.out.println("Jogador: " + jogadorAtual + ", " + "digite a linha e a coluna");
			int linha = leia.nextInt() - 1;
			int coluna = leia.nextInt() - 1;

			if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {

				tabuleiro[linha][coluna] = jogadorAtual;
				if (verificarVitoria(tabuleiro,jogadorAtual) == true) { // verificar se ganhou
					mostrarTabuleiro(tabuleiro);
					System.out.println("Jogador: " + jogadorAtual + " venceu!");
					jogoRolando = false;
				} else if (verificarEmpate(tabuleiro) == true) { // Verificar o empate
					mostrarTabuleiro(tabuleiro);	
					System.out.println("Empate");
					jogoRolando = false;
				} else {

					if (jogadorAtual == 'X') {
						jogadorAtual = 'O';
					} else {
						jogadorAtual = 'X';
					}
				}

			} else {
				System.out.println("Jogada inválida, tente novamente");
			}

		}

	}

	private static boolean verificarVitoria(char[][] tabuleiro, char jogadorAtual) {
		
		if (tabuleiro[0][0] == jogadorAtual  
				&&  tabuleiro[1][1] == jogadorAtual  
				&&  tabuleiro[2][2] == jogadorAtual) {
			return true;
		}
		
		
		
		return false;
	}

	private static boolean verificarEmpate(char[][] tabuleiro) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	private static void inicializarTabuleiro(char[][] tabuleiro) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}

	private static void mostrarTabuleiro(char[][] tabuleiro) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tabuleiro[i][j]);
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < 2) {
				System.out.println("____________");
			}

		}

	}

}
