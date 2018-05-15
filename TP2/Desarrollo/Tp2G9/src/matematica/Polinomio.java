package matematica;


public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado){
	this.grado=grado;
	this.coeficientes=new double [grado+1];
	
}
	
	//ejercicio 1
	double evaluarMSucesivas(double x) 
	{
		double acumuladortot = 0;
		double acumulSucesivo = 0;
		acumuladortot = this.coeficientes[this.grado]; // COLOCO DE ENTRADA EL TERMINO INDEPENDIENTE
		int j = 0, // SUB INDICE PARA RECORRER EL POLI
		n = this.grado;
		while (j < this.grado) {
			acumulSucesivo = x;
			for (int i = 0; i < n - 1; i++) //	RESULVE LA POTENCIA
			{		
				acumulSucesivo *= x;
			}
			acumuladortot += (this.coeficientes[j] * acumulSucesivo);
			acumulSucesivo = 0;
			j++;
			n--;
		}
		return acumuladortot;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////   A
	public double evaluarRecurA(double x) 
	{
		double acumuladortot = this.coeficientes[this.grado];
		int grado = this.grado;
		for (int i = 0; i < this.grado; i++) {
			acumuladortot += this.coeficientes[i] * potencia(x, grado--);
		}
		return acumuladortot;

	}
	
	public double potencia(double x, int n) 
	{
		if (n == 0)
			return 1;
		return x * potencia(x, n - 1);
	}
///////////////////////////////////////////////////////////////////////////////////////////////  B
	public double evaluarRecurB(double x) {
		double acumuladortot = this.coeficientes[this.grado];
		int grado = this.grado;
		for (int i = 0; i < this.grado; i++) {
			acumuladortot += this.coeficientes[i] * potenciaParoImpar(x, grado--);
		}
		return acumuladortot;

	}

	public double potenciaParoImpar(double x, int n) // RESULVE LA POTENCIA DE ACUERDO SI ES PAR O IMPAR EL EXPONENTE
	{
		if(n==0)
			return 1;
		if (n % 2 == 0)	// IDENTIFICO SI EL EXP ES PAR O IMPAR
			
			return potenciaPar( x, n );// UTILIZA EL CALCULO potencia( x.x , n/2)		

		 return x*potenciaPar(x,n-1); // UTILIZA EL CALCULO x∗ potencia( x , n−1)
	}

	public double potenciaPar(double x, int n) {
		if (n == 2)
			return x * x;
		return potenciaParoImpar(x*x , n/2 );
}
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Ejercicio 3 
	public double evaluarProgDinamica(double x) {
		double acumuladortot=this.coeficientes[this.grado];
		double [] potencias = new double[this.grado+1];
		potencias[0]=1; 
		for(int i=1; i<=this.grado; i++)
		{
			potencias[i]= x * potencias[i-1]; 
		}
		for(int i=0; i<this.grado ; i++)
		{
			acumuladortot+=this.coeficientes[i]* potencias[ this.grado-i];
		}
	return acumuladortot;
	}
	
	//Ejercicio 4
	public double evaluarMejorada(double x) {
		double acumuladortot=this.coeficientes[this.grado];
		double potencia=1; 
		for(int i=0; i<=this.grado; i++)
		{ 
			acumuladortot += this.coeficientes[ this.grado-i ] * potencia ;
			potencia*=x;
		}
	return acumuladortot;
	}
	
	
	// Ejercicio 5
	public double evaluarPow(double x) {
		double acumuladortot = this.coeficientes[this.grado];
		int grado = this.grado;
		for (int i = 0; i < this.grado; i++) {
			acumuladortot += this.coeficientes[i] * Math.pow(x, grado--);
		}
		return acumuladortot;
	}
 
	// Ejercicio 6
	public double evaluarHorner(double x) {
		double sum = coeficientes[0] * x;
		int i = 1;
		for (; i < this.grado; i++)
			sum = (sum + coeficientes[i]) * x;
		return sum + coeficientes[i];
	}
	
	

	public void cargarPoli(double[] aux) {
		for (int i = 0; i < this.grado; i++) {
			this.coeficientes[i] = aux[i];
		}
	}

	public void cargarconVector()
	{
		for( int j =0; j<= this.grado; j++)
		{
			this.coeficientes[j] = (int)(Math.random()*10);
		}
	}
	
	public void verPoli() {
		int i = 0;
		int n = this.grado;
		while (i <= this.grado) {
			System.out.println(+this.coeficientes[i] + "x^" + n-- + "+");
			i++;
		}
	}
}
