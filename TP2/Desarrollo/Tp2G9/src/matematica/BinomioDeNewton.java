package matematica;

public class BinomioDeNewton {
	private double a;
	private double b;
	private int n;
	private double[] coef;
	private double[][] triangulo;
	private double[] potencias;
		
	public BinomioDeNewton() //(ax+b)^n
	{
		this.a=1;
		this.b=0;
		this.n=1;
		this.coef= this.potencias=new double[1];
		this.triangulo = new double[1][1];
	}
	
	public BinomioDeNewton(double a, double b, int n)
	{
		this.a=a;
		this.b=b;
		this.n=n;
		this.coef= this.potencias=new double[n+1];
		this.triangulo=new double[this.n+1][this.n+1];
	}
	
	public int getGrado()
	{
		return this.n;
	}
	
	public double getA()
	{
		return this.a;
	}
	
	public double getB()
	{
		return this.b;
	}	

	/*-------------------Calcular las potencias de los t�rminos a y b del binomio-------------------*/
	

	//Calcula las potencias de a y b en un solo array
	public void potenciasJuntas()
	{
		for(int i=0;i<=this.n;i++)
		{
			this.potencias[i]= Math.pow(this.a, this.n-i) * Math.pow(this.b, i);
		}
	}
	
	/*----------------------------------Uso de matriz----------------------------------*/
	
	//Uso de matriz para construir el tri�ngulo de Pascal:
	//Construyendo el tri�ngulo de Pascal seg�n sus propiedades, no es necesario calcular las combinatorias
	//de todos los coeficientes del binomio.
	
	public void cargarMatrizCoefPascal() //Crea todo el triangulo por propiedades (sin combinatoria)
	{
		for(int i=0;i<=n;i++)
		{
			this.triangulo[i][0]=this.triangulo[i][i]=1;
			for(int j=1;j<i;j++)
				this.triangulo[i][j]=(this.triangulo[i-1][j] + this.triangulo[i-1][j-1]);// * this.potencias[j];
		}
		//this.coef=this.triangulo[this.n]; //Guarda los coeficientes de ese binomio
		
		//Puede implementarse o no el uso del array "coef": se puede usar acceso directo a la matriz tri�ngulo
	}
		
	
	//Uso de matriz para construir el tri�ngulo de Pascal, calculando la combinatoria:

	public void cargarMatrizCoeficientes() //Crea el triangulo calculando la combinatoria
	{	
		for(int i=0;i<=n;i++)
		{
			this.triangulo[i][0]=this.triangulo[i][i]=1;
			for(int j=1;j<i;j++)
				this.triangulo[i][j]=combinatoria(i, j);// * this.potencias[j];
		}
		//this.coef=this.triangulo[this.n];
		
		//Nuevamente no es necesario el uso del array "coef"
	}
	
	
	/*----------------------------------Uso de array----------------------------------*/
	
	
	//Uso del array para crear el tri�ngulo, sin memoria: crea el tri�ngulo y s�lo devuelve
	//los coeficientes para ese binomio. Tampoco usa combinatoria, sino que la propiedad del tri�ngulo.
	
	public double[] coeficientesDesdeArray() //Solo devuelve los coeficientes del tri�ngulo
	{
		double[] anterior= new double[this.n+1];
				
		for(int i=0;i<=this.n;i++)
		{
			this.coef[0]=this.coef[i]= 1;
			if(i==0)
				anterior=this.coef.clone();
			for(int j=1;j<i;j++)
			{
				this.coef[j]= (anterior[j-1] + anterior[j]); // * potencias[j];
			}
			anterior=this.coef.clone();
		}
		
		return this.coef;
		//Aca no se implementa la matriz, sino que el array "coef" y uno auxiliar para recordar la fila anterior
	}
	
	
	//Recorre el array "coef" y lo llena calculando la combinatoria
	
	public double[] coeficientes()
	{
		for(int i=0;i<=this.n;i++)
			this.coef[i]=(int)combinatoria(this.n, i) * this.potencias[i];
		return this.coef;
	}
	
	
	/*--------------------------------------Recursividad--------------------------------------*/
	
	
	//Calcula con combinatoria los coeficientes de forma recursiva
	public double[] coeficientesRec(int f) 
	{
		if(f==0)
		{
			this.coef[0]=1 * this.potencias[0];
			return this.coef;
		}		
		this.coef[f]= this.potencias[f] * (int)combinatoria(this.n, f--);
		return coeficientesRec(f);		
	}	
	
	
	/*--------------------Obtenci�n del coeficiente del t�rmino k para ese binomio--------------------*/
	

	//Retorna el coeficiente del t�rmino k desde la matriz: sin usar el array "coef"
	
	public double coefKDesdeMatriz(int k) 
	{
		return this.triangulo[this.n][k-1] * this.potencias[k-1];
	}
	
	//Retorna el coeficiente del t�rmino k desde el array "coef"
	
	public double coefTerminoK(int k)
	{
		return this.coef[k-1];
	}
	
	//Calcula todo: combinatoria y potencias de los t�rminos a y b del dinomio
	
	public double coeficienteTerminoK(int k)
	{
		return combinatoria(this.n, k-1) * Math.pow(this.a, n-k-1) * Math.pow(this.b, k-1);
	}
	
	
	/*--------------------Resoluci�n del binomio para un x dado--------------------*/
	
	//Retorna el valor final del binomio en x
	
	public double resolverBinomio(double x)
	{
		double resFinal=0;
		
		for(int i=0;i<=n;i++)
			resFinal+= i==n?this.coef[i]:(this.coef[i] * Math.pow(x, n-i));
		return resFinal;
	}
	
	//Retorna el valor final del binomio en x, recursiva
	
	public double resolverBinomioRec(double x, int n)
	{
		if(n==0)
		{
			double r=this.coef[n];
			return r;
		}
		double r=x*resolverBinomioRec(x, n-1) + this.coef[n];
		return r;
	}

	
	/*--------------------C�lculos: combinatoria y factorial--------------------*/
	
	
	//Factorial iterativa
	
	public double factorial(int n)
	{
		int res=1, i=n;
		while(i>0)//for(int i=n; i>0;i--)
		{
			res*=i;
			i--;
		}
		return res;
	}
	
	//Factorial recursiva
	
	public double factorialRec(int n)
	{
		if(n>0)
			return n*factorialRec(n-1);
		else
			return 1;			
	}
	
	/////Combinatoria: factorial iterativa
	
	public double combinatoria(int n, int p)
	{
		return factorial(n)/(factorial(p)*factorial(n-p));
	}	
}