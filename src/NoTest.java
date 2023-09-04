

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void deveRetornarEhNoFolhaSoFilhoDireito() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, noUm, null);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolhaSoFilhoEsquerdo() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, null, noUm);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	

	@Test
	void deveRetornarEhNoFolhaDoisFilhos() {
		No noUm = new No(1, null, null); 
		No noDois = new No(2, null, null);
		No noTres = new No(3, noUm, noDois);
		
		assertFalse(noTres.ehFolha());
		assertTrue(noUm.ehFolha());
		assertTrue(noDois.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolha() {
		No noUm = new No(1, null, null); 
		assertTrue(noUm.ehFolha());
	}

}
