import java.util.Scanner;

public class Executar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String valor1, valor2;
		System.out.println("Valor 1: ");
		valor1 = scanner.next();
		System.out.println("Valor 2: ");
		valor2 = scanner.next();
		scanner.close();
		Operacao op = new Operacao();
		try {
			System.out.println(op.somarHexadecimal(valor1.toString(), valor2.toString()));
		}catch (Exception e) {
			System.out.println("Errou!!\n");
		}
	}

}
