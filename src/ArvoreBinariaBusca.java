

public class ArvoreBinariaBusca {

	private static final String OPERACAO_INVALIDA_ARVORE_VAZIA = "Operacao Invalida: arvore vazia";
	private No raiz;
	
	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1 + pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(No noReferencia) {
		if (ehVazia()) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito()); // 2
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo()); // 0

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(No noReferencia) {

		if (ehVazia()) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noReferencia) - 1;
		}
	}

	private int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noReferencia.getValor()) {
				return 1;
			}

			if (noBuscado.getValor() < noReferencia.getValor()) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No pegarNoArvorePorValor(int valorBuscado) {

		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz);
	}

	private No buscaValorNoReferenciaSeusDescendentes(int valorBuscado, No noReferencia) {

		if (noReferencia == null) {
			return null;
		}

		if (valorBuscado == noReferencia.getValor()) {
			return noReferencia;
		}

		if (valorBuscado < noReferencia.getValor()) {
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getEsquerdo());
		} else {
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getDireito());
		}
	}

	public boolean contem(int valorBuscado) {

		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz) != null;
	}
	
	public void adicionaNo(int valorNoAdicionado) {
		
		if (ehVazia()) {
			this.raiz = new No(valorNoAdicionado, null, null);
		}
		else {
			insereNovoNoArvoreRercursivamente(raiz, valorNoAdicionado);
		}	
	}
	
	public void insereNovoNoArvoreRercursivamente(No noReferencia, int valorNoAcionado) {
		
		if (noReferencia != null) {
			
			if (valorNoAcionado < noReferencia.getValor()) {
				
				 if (noReferencia.getEsquerdo() == null) {
					 No novoNo = new No(valorNoAcionado, null, null);
					 noReferencia.setEsquerdo(novoNo);
					 
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getEsquerdo(), valorNoAcionado);
				 }
			}
			else {
				
				 if (noReferencia.getDireito() == null) {
					 No novoNo = new No(valorNoAcionado, null, null);
					 noReferencia.setDireito(novoNo);
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getDireito(), valorNoAcionado);
				 }
			}
		}
	}
	
	public void removerNoPorValor(int valorRemovido) {
		
		if (ehVazia()) {
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		}
		else {
			raiz = removerNoArvoreRecursivamente(raiz, valorRemovido);
		}
	}
	
	public No removerNoArvoreRecursivamente(No noReferencia, int valorRemovido) {
		
			if (noReferencia == null) {
				return null;
			}
			
			if (valorRemovido == noReferencia.getValor()) {
				
				if (noReferencia.ehFolha()) {
					return null;
				}
				
				else if (soFilhoDireito(noReferencia)) {
					 return noReferencia.getDireito();
				}
				else if (soFilhoEsquerdo(noReferencia)) {
					return noReferencia.getEsquerdo();
				}
				else {
					int menorValor = pegaMenorValor (noReferencia.getDireito());
					noReferencia.setValor(menorValor);
					noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), menorValor));
					return noReferencia;
				}
			}
			
			if (valorRemovido < noReferencia.getValor()) {
				 noReferencia.setEsquerdo(removerNoArvoreRecursivamente(noReferencia.getEsquerdo(), valorRemovido));	 
			}
			else {
				 noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), valorRemovido));
			}
			return noReferencia;
			
	}
	
	private boolean soFilhoDireito(No noReferencia) {
		return ((noReferencia.getDireito() != null) && (noReferencia.getEsquerdo() == null));
	}
	
	private boolean soFilhoEsquerdo(No noReferencia) {
		return ((noReferencia.getDireito() == null) && (noReferencia.getEsquerdo() != null));
	}
	
	private int pegaMenorValor(No noReferencia) {
		if (noReferencia.getEsquerdo() == null) {
			return noReferencia.getValor();
		}
		else {
			return pegaMenorValor(noReferencia.getEsquerdo());
		}
	}

	public void emOrdem(No noReferencia) {
		if (noReferencia != null) {
			emOrdem(noReferencia.getEsquerdo());
			System.out.println(noReferencia.getValor());
			emOrdem(noReferencia.getDireito());
		}
	}
	public void preOrdem(No noReferencia) {
		if (noReferencia != null) {
			System.out.println(noReferencia.getValor());
			preOrdem(noReferencia.getEsquerdo());
			preOrdem(noReferencia.getDireito());
		}
	}
	public void posOrdem(No noReferencia) {
		if (noReferencia != null) {
			posOrdem(noReferencia.getEsquerdo());
			posOrdem(noReferencia.getDireito());
			System.out.println(noReferencia.getValor());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
