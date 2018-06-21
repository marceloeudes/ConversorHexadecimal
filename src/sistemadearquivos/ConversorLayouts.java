package sistemadearquivos;

import conversores.Conversor;

public class ConversorLayouts {

	public static String obterHoraMinSeg(String numero1, String numero2) {
		String hexadecimal = numero1 + " " + numero2;
		int somaBinario = 0, posicao = 0;
		String hora = "", min = "", seg = "";
		StringBuilder sb = new StringBuilder();
		char[] arrayChar = converterParaBinario(inverterHexa(hexadecimal));
		for (int i = 15; i >= 0; i--) {
			if (posicao > 0) {
				posicao = posicao * 2;
				somaBinario = somaBinario + (posicao * Integer.parseInt(String.valueOf(arrayChar[i])));
			} else {
				if (arrayChar[i] == '1') {
					somaBinario = 1;
				}
				posicao = 1;
			}
			if (i == 11) {
				seg = Integer.toString(somaBinario * 2);
				somaBinario = 0;
				posicao = 0;
			}
			if (i == 5) {
				min = Integer.toString(somaBinario);
				somaBinario = 0;
				posicao = 0;
			}
			if (i == 0) {
				hora = Integer.toString(somaBinario);
			}
		}
		if (hora.length() == 1) {
			sb.append("0").append(hora).append(":");
		} else {
			sb.append(hora).append(":");
		}
		if (min.length() == 1) {
			sb.append("0").append(min).append(":");
		} else {
			sb.append(min).append(":");
		}
		if (seg.length() == 1) {
			sb.append("0").append(seg);
		} else {
			sb.append(seg);
		}
		return sb.toString();
	}

	public static String obterData(String numero1, String numero2) {
		String hexadecimal = numero1 + " " + numero2;
		int somaBinario = 0, posicao = 0;
		String ano = "", mes = "", dia = "";
		StringBuilder sb = new StringBuilder();
		char[] arrayChar = converterParaBinario(inverterHexa(hexadecimal));
		for (int i = 15; i >= 0; i--) {
			if (posicao > 0) {
				posicao = posicao * 2;
				somaBinario = somaBinario + (posicao * Integer.parseInt(String.valueOf(arrayChar[i])));
			} else {
				if (arrayChar[i] == '1') {
					somaBinario = 1;
				}
				posicao = 1;
			}
			if (i == 11) {
				dia = Integer.toString(somaBinario);
				somaBinario = 0;
				posicao = 0;
			}
			if (i == 7) {
				mes = Integer.toString(somaBinario);
				somaBinario = 0;
				posicao = 0;
			}
			if (i == 0) {
				ano = Integer.toString(somaBinario + 1980);
			}
		}
		if (dia.length() == 1) {
			sb.append("0").append(dia).append("/");
		} else {
			sb.append(dia).append("/");
		}
		if (mes.length() == 1) {
			sb.append("0").append(mes).append("/");
		} else {
			sb.append(mes).append("/");
		}
		sb.append(ano);
		return sb.toString();
	}

	public static String calcularPosicaoGranulo(String tamAreaReservada, String tamFats, String tamDiretorioRaiz,
			String numGranulo, String tamGranulo) {
		int tamAreaReservadaDec = Conversor.hexadecimalParaDecimal(tamAreaReservada);
		int tamFatsDec = Conversor.hexadecimalParaDecimal(tamFats);
		int tamDiretorioRaizDec = Conversor.hexadecimalParaDecimal(tamDiretorioRaiz);
		int numGranuloDec = Conversor.hexadecimalParaDecimal(numGranulo);
		int tamGranuloDec = Conversor.hexadecimalParaDecimal(tamGranulo);
		int valorFinalDecimal = (tamAreaReservadaDec + tamFatsDec + tamDiretorioRaizDec
				+ ((numGranuloDec - 2) * tamGranuloDec));
		return Conversor.decimalParaHexadecimal(valorFinalDecimal);
	}

	public static String calcularUltimoFragmento(String tamArquivo, int qtdGranulos, String tamGranulo,
			String posicaoGranulo) {
		int posicaoGranuloDec = Conversor.hexadecimalParaDecimal(posicaoGranulo);
		int tamArquivoDec = Conversor.hexadecimalParaDecimal(tamArquivo);
		int tamGranuloDec = Conversor.hexadecimalParaDecimal(tamGranulo);
		int qtdBytesUsados = tamArquivoDec - ((qtdGranulos - 1) * tamGranuloDec);
		int deslocamento = posicaoGranuloDec + qtdBytesUsados - 32;
		return Conversor.decimalParaHexadecimal(deslocamento);
	}

	public static char[] inverterHexa(String hexadecimal) {
		String[] hexaByte = hexadecimal.split(" ");
		int indice = hexaByte.length - 1;
		int tam = hexaByte.length * 2;
		int aux = 0;
		char[] arrayInvertido = new char[tam];
		for (int i = 0; i < tam; i++) {
			arrayInvertido[i] = hexaByte[indice].charAt(aux);
			aux++;
			if (aux == 2) {
				aux = 0;
				indice--;
			}
		}
		return arrayInvertido;
	}

	public static char[] converterParaBinario(char[] arrayChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arrayChar.length; i++) {
			String binario = Integer.toBinaryString(Conversor.caracterHexadecimalParaDecimal(arrayChar[i]));
			if (binario.length() < 4) {
				if (binario.length() == 3) {
					binario = "0" + binario;
				} else if (binario.length() == 2) {
					binario = "00" + binario;
				} else {
					binario = "000" + binario;
				}
			}
			sb.append(binario);
		}
		arrayChar = sb.toString().toCharArray();
		return arrayChar;
	}
}
