package conversores;
public class Conversor {

	public static String decimalParaHexadecimal(int decimal) {
		return Integer.toHexString(decimal);
	}
	
	public static Integer hexadecimalParaDecimal(String hexadecimal) {
		int valor = 0, posicao = 0;
		for (char numero : hexadecimal.toCharArray()) {
			double valorPosicao = Math.pow(16, posicao);
			valor += caracterHexadecimalParaDecimal(numero) * valorPosicao;
			posicao++;
		}
		return valor;
	}

	public static Integer caracterHexadecimalParaDecimal(Character hexadecimal) {
		int numero = 0;
		if (!(hexadecimal == null)) {
			switch (hexadecimal) {
			case 'a':
			case 'A':	
				numero = 10;
				break;
			case 'b':
			case 'B':
				numero = 11;
				break;
			case 'c':
			case 'C':
				numero = 12;
				break;
			case 'd':
			case 'D':
				numero = 13;
				break;
			case 'e':
			case 'E':
				numero = 14;
				break;
			case 'f':
			case 'F':	
				numero = 15;
				break;
			default:
				numero = Integer.parseInt(String.valueOf(hexadecimal));
				break;
			}
		}
		return numero;
	}

	public static char caracterDecimalParaHexadecimal(int decimal) {
		char numero;
		switch (decimal) {
		case 10:
			numero = 'A';
			break;
		case 11:
			numero = 'B';
			break;
		case 12:
			numero = 'C';
			break;
		case 13:
			numero = 'D';
			break;
		case 14:
			numero = 'E';
			break;
		case 15:
			numero = 'F';
			break;
		default:
			numero = String.valueOf(decimal).charAt(0);
			break;
		}
		return numero;
	}

}
