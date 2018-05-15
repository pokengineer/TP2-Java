package matematica;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.*;

class PolinomioTest {

	Polinomio poli = new Polinomio(4);
	double[] coef = { 5,9,8,7};
	
//	@Before
//	void carga() {
//		poli.cargarPoli(coef);
//	}
//	
	@Test
	void prueba2A() {
		poli.cargarPoli(coef);
		Assert.assertEquals( 198 , poli.evaluarRecurA(2), 0.1);
	}
	
	@Test
	void prueba2B() {
		poli.cargarPoli(coef);
		Assert.assertEquals( 198 , poli.evaluarRecurB(2), 0.1);
	}
	
	@Test
	void prueba1() {
		poli.cargarPoli(coef);
		Assert.assertEquals( 198 , poli.evaluarMSucesivas(2), 0.1);
	}
	
	@Test
	void prueba6() {
		poli.cargarPoli(coef);
		Assert.assertEquals( 198 , poli.evaluarHorner(2), 0.1);
	}
	
	@Test
	void prueba5() {
		poli.cargarPoli(coef);
		Assert.assertEquals(198 , poli. evaluarPow(2), 0.1 );
	}
	
	@Test
	void prueba3() {
		poli.cargarPoli(coef);
		Assert.assertEquals(198 , poli.evaluarProgDinamica(2), 0.1 );
	}

	@Test
	void prueba4() {
		poli.cargarPoli(coef);
		Assert.assertEquals(198 , poli.evaluarMejorada(2), 0.1 );
	}
	
}
