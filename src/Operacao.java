public class Operacao {

	private Character[] valorAcima;
	private Character[] valorAbaixo;
	private Character[] resultado;

	public Operacao() {
		valorAcima = new Character[10];
		valorAbaixo = new Character[10];
		resultado = new Character[10];
	}

	public String somarHexadecimal(String valor1, String valor2) {

		int posicao = 9, vezes = 0, resto = 0;
		Conversor con = new Conversor();

		for (char numero : valor1.toCharArray()) {
			valorAcima[posicao] = numero;
			posicao--;
		}

		posicao = 9;

		for (char numero : valor2.toCharArray()) {
			valorAbaixo[posicao] = numero;
			posicao--;
		}

		posicao = 9;

		for (int i = 0; i < 10; i++) {

			int somacoluna = somaDecimal(con.obterDecimal(valorAcima[posicao]), con.obterDecimal(valorAbaixo[posicao]));
			somacoluna = somacoluna + vezes;
			vezes = 0;
			if (somacoluna > 15) {
				vezes = somacoluna / 16;
				resto = somacoluna % 16;
				resultado[9 - i] = con.obterHexadecimal(resto);
			} else {
				resultado[9 - i] = con.obterHexadecimal(somacoluna);
			}
			posicao--;
		}

		if (vezes > 0) {
			resultado[0] = con.obterHexadecimal(vezes);
		}

		StringBuilder sb = new StringBuilder();
		for (char c : resultado) {
			sb.append(c);
		}

		return sb.toString();
	}

	private Integer somaDecimal(int valor1, int valor2) {
		return valor1 + valor2;
	}
}
