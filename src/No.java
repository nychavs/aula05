

public class No {

	private int valor;
	private No direito;
	private No esquerdo;

	public No(int valor, No direito, No esquerdo) {
		this.valor = valor;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}
}
