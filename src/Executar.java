import java.util.Scanner;

public class Executar {

	public static void main(String[] args) {
		Integer opcao = null;
		try {
			Scanner scanner = new Scanner(System.in);
		while (opcao == null || opcao > 0) {
			String numero1, numero2;
			displayInfo();
			opcao = Integer.parseInt(scanner.next());
			switch (opcao) {
				case 1:
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.println("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("%s + %s = %s\n", numero1, numero2, Operacao.somarHexadecimal(numero1, numero2));
					break;
				case 2:
					System.out.print("Numero 1: ");
					numero1 = scanner.next();
					System.out.println("Numero 2: ");
					numero2 = scanner.next();
					System.out.printf("%s * %s = %s\n", numero1, numero2, Operacao.multiplicarHexadecimal(numero1, numero2));
					break;	
				case 0:
					break;
			}
		}
		scanner.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void displayInfo() {
		System.out.println("\n");
		System.out.println("*********************");
		System.out.println("*     CONVERSOR     *");
		System.out.println("*********************");
		System.out.println("*  OPCOES:          *");
		System.out.println("*  0 - SAIR         *");
		System.out.println("*  1 - SOMAR HEXA   *");
		System.out.println("*  2 - MULTI HEXA   *");
		System.out.println("*********************");
	}

}
