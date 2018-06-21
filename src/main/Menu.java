package main;

import java.util.Scanner;

import conversores.Operacao;
import sistemadearquivos.ConversorLayouts;

public class Menu {

	public static void main(String[] args) {
		String opcao = " ", numero1 = "", numero2 = "", numero3 = "", numero4 = "", numero5 = "", numero6 = "",
				numero7 = "", posicao = "";
		try {
			Scanner scanner = new Scanner(System.in);
			while (opcao != null) {
				displayInfo();
				System.out.print("Opcao: ");
				opcao = scanner.next();
				switch (opcao) {
				case "1":
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.print("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("\n==>%s + %s = %s\n", numero1, numero2,
							Operacao.somarHexadecimal(numero1, numero2));
					break;
				case "2":
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.print("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("\n==>%s * %s = %s\n", numero1, numero2,
							Operacao.multiplicarHexadecimal(numero1, numero2));
					break;
				case "3":
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.print("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("\n==>%s\n", ConversorLayouts.obterHoraMinSeg(numero1, numero2));
					break;
				case "4":
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.print("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("\n==>%s\n", ConversorLayouts.obterData(numero1, numero2));
					break;
				case "5":
					System.out.println("Ja informou? (S/N)");
					if (scanner.next().charAt(0) == 'N') {
						System.out.print("Tamanho Area Reservada: ");
						numero3 = scanner.next();
						System.out.print("Tamanho das FATS: ");
						numero4 = scanner.next();
						System.out.print("Tamanho do Diretorio Raiz: ");
						numero5 = scanner.next();
						System.out.print("Numero do Granulo: ");
						numero6 = scanner.next();
						System.out.print("Tamanho do Granulo: ");
						numero7 = scanner.next();
					} else {
						System.out.print("Numero do Granulo: ");
						numero6 = scanner.next();
					}
					posicao = ConversorLayouts.calcularPosicaoGranulo(numero3, numero4, numero5, numero6, numero7);
					System.out.printf("\n==>%s\n", posicao);
					break;
				case "6":
					if (posicao != "") {
						System.out.print("Tamanho Arquivo: ");
						numero1 = scanner.next();
						System.out.print("Quantidade de Granulos: ");
						numero2 = scanner.next();
						System.out.printf("\n==>%s\n", ConversorLayouts.calcularUltimoFragmento(numero1,
								Integer.parseInt(numero2), numero7, posicao));
					}
					break;
				case "7":
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.print("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("\n==>%s\n", Operacao.subtrairHexadecimal(numero1, numero2));
					break;
				case "0":
					opcao = null;
					break;
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void displayInfo() {
		System.out.println("\n");
		System.out.println("********************************************************");
		System.out.println("*                       CONVERSOR                      *");
		System.out.println("********************************************************");
		System.out.println("*  OPCOES:                                             *");
		System.out.println("*  0 - SAIR         3 - HORA/MIN/SEG  6 - ULTIMO FRAG  *");
		System.out.println("*  1 - SOMAR HEXA   4 - DATA          7 - SUBTRA HEXA  *");
		System.out.println("*  2 - MULTI HEXA   5 - PG                             *");
		System.out.println("********************************************************");
	}

}
