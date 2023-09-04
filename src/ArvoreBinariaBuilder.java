

public class ArvoreBinariaBuilder {
	
	private ArvoreBinariaBusca arvore;
		
	public ArvoreBinariaBusca montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBusca();
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreSoRaiz() {
		No noCinco = new No(5, null, null);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireito() {
		No noSete = new No(7, null, null);
		No noCinco = new No(5, noSete, null);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoEsquerdo() {
		No noTres = new No(3, null, null);
		No noCinco = new No(5, null, noTres);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireitoEsquerdo() {
		No noSete = new No(7, null, null);
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoUmEsquerdo() {
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, null);
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizUmFilhoDireitoDoisEsquerdo() {
		No noSete = new No(7, null, null);
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoDoisEsquerdo() {
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, null);
		No noCinco = new No(5, noSete, noTres);
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreCheiaDoisNiveis() {
		No noUm = new No(1, null, null);
		No noQuatro = new No(4, null, null);
		No noTres = new No(3, noQuatro, noUm);
		No noOito = new No(8, null, null);
		No noSeis = new No(6, null, null);
		No noSete = new No(7, noOito, noSeis);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noCinco);
		return arvore;
	}
	

}
