public class Operacao {

	public static String somarHexadecimal(String valor1, String valor2) {
		return Conversor.decimalParaHexadecimal(
				Conversor.hexadecimalParaDecimal(valor1) + Conversor.hexadecimalParaDecimal(valor2));
	}

	public static String multiplicarHexadecimal(String valor1, String valor2) {
		return Conversor.decimalParaHexadecimal(
				Conversor.hexadecimalParaDecimal(valor1) * Conversor.hexadecimalParaDecimal(valor2));
	}

	public static Integer somaDecimal(int valor1, int valor2) {
		return valor1 + valor2;
	}

	public static Integer multiplicaDecimal(int valor1, int valor2) {
		return valor1 * valor2;
	}
}
