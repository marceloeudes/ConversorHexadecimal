
public class Conversor {

	public String decimalParaHexa(int decimal) {
		return Integer.toHexString(decimal);
	}
	
	public Integer obterDecimal(Character hexadecimal) {
		int numero = 0;
		if (!(hexadecimal == null)) {
			switch (hexadecimal) {
			case 'a':
				numero = 10;
				break;
			case 'b':
				numero = 11;
				break;
			case 'c':
				numero = 12;
				break;
			case 'd':
				numero = 13;
				break;
			case 'e':
				numero = 14;
				break;
			case 'f':
				numero = 15;
				break;
			default:
				numero = Integer.parseInt(String.valueOf(hexadecimal));
				break;
			}
		}
		return numero;
	}

	public char obterHexadecimal(int decimal) {
		char numero;
		switch (decimal) {
		case 10:
			numero = 'a';
			break;
		case 11:
			numero = 'b';
			break;
		case 12:
			numero = 'c';
			break;
		case 13:
			numero = 'd';
			break;
		case 14:
			numero = 'e';
			break;
		case 15:
			numero = 'f';
			break;
		default:
			numero = String.valueOf(decimal).charAt(0);
			break;
		}
		return numero;
	}

}
