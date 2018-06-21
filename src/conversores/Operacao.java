package conversores;
public class Operacao {

	public static String somarHexadecimal(String valor1, String valor2) {
		return Conversor.decimalParaHexadecimal(
				Conversor.hexadecimalParaDecimal(valor1) + Conversor.hexadecimalParaDecimal(valor2));
	}
	
	public static String subtrairHexadecimal(String valor1, String valor2) {
		return Conversor.decimalParaHexadecimal(
				Conversor.hexadecimalParaDecimal(valor1) - Conversor.hexadecimalParaDecimal(valor2));
	}

	public static String multiplicarHexadecimal(String valor1, String valor2) {
		return Conversor.decimalParaHexadecimal(
				Conversor.hexadecimalParaDecimal(valor1) * Conversor.hexadecimalParaDecimal(valor2));
	}
}
