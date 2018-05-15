package matematica;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinomioDeNewtonTest {

	BinomioDeNewton bin = new BinomioDeNewton(2,3,2);
	double[] exp = {4, 12, 9};
	double x=1;
	double res=25; 
	
	//Dos maneras de cargar la matriz
	
	/*@Test
	public void potenciasJuntas()
	{
		long tInicial = System.currentTimeMillis();
		bin.potenciasJuntas();
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("potenciasJuntas: " + t + "ms");
	}
	@Test
	public void cargarMatrizCoefPascal()
	{
		long tInicial = System.currentTimeMillis();
		bin.cargarMatrizCoefPascal();
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("cargarMatrizCoefPascal: " + t);
	}
	
	@Test
	public void cargarMatrizCoeficientes()
	{
		long tInicial = System.currentTimeMillis();
		bin.cargarMatrizCoeficientes();
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("cargarMatrizCoeficientes: " + t);
	}*/
	
	
	@Before
	public void inicializar()
	{		
		bin.potenciasJuntas();
		bin.cargarMatrizCoefPascal(); //Probamos primero con esta carga
		//bin.cargarMatrizCoeficientes();
	}
		
	@Test
	public void coeficienteTerminoK()
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertNotEquals(bin.getA()*bin.getGrado(), bin.coeficienteTerminoK(1), 0.1);
		//bin.coeficienteTerminoK(1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coeficienteTerminoK: " + t + "ms");
	}
	
	@Test
	public void coefTerminoK()
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertEquals(bin.getA()*bin.getGrado(), bin.coefTerminoK(1), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coefTerminoK: " + t + "ms");
	}
	
	@Test
	public void coefKDesdeMatriz()
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertEquals(bin.getA()*bin.getGrado(), bin.coefKDesdeMatriz(1), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coefKDesdeMatriz: " + t + "ms");
	}
	
	
	@Test
	public void coeficientes()
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertArrayEquals(exp, bin.coeficientes(), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coeficientes: " + t + "ms");
	}
	
	@Test
	public void coeficientesDesdeArray()
	{
		double[]c= {1,2,1};
		long tInicial = System.currentTimeMillis();
		Assert.assertArrayEquals(c, bin.coeficientesDesdeArray(), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coeficientesDesdeArray: " + t + "ms");
	}
	
	@Test
	public void coeficientesRec() //Stack overflow @ n=5357
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertArrayEquals(exp, bin.coeficientesRec(bin.getGrado()), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("coeficientesRec: " + t + "ms");	
	}
	
	@Test
	public void resolverBinomio()
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertEquals(res-6, bin.resolverBinomio(x), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("resolverBinomio: " + t + "ms");
	}
	
	@Test
	public void resolverBinomioRec() //Stack overflow @ n=8079
	{
		long tInicial = System.currentTimeMillis();
		Assert.assertNotEquals(res, bin.resolverBinomioRec(x, bin.getGrado()), 0.1);
		long tFinal = System.currentTimeMillis();
		
		long t = tFinal-tInicial;
		System.out.println("resolverBinomioRec: " + t + "ms");
	}
}
