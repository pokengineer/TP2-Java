package polinomios;

import java.util.Scanner;

public class Polinomio{
	
		private int grado ;
		private double [] coeficientes;
		//La p o s i c i o n 0 d e l a r r e g l o de c o e f i c i e n t e s c o n t i e n e e l c o e f i c i e n t e de grado n y l a
		//p o s i c i o n n c o n t i e n e a l term ino i n d e p e n d i e n t e .
		public Polinomio(int grado){
		this.grado=grado;
		this.coeficientes=new double [grado+1];
		
		}
		double evaluarMSucesivas(double x ) ///EVALUAR EN EL POLI POR MEDIO DE MULTIPLICACIONES SUCESIVAS
		{ 
			double acumuladortot=0;
			double acumulSucesivo=0;
			acumuladortot=this.coeficientes[this.grado]; //COLOCO DE ENTRADA EL TERMINO INDEPENDIENTE
			int j=0,//SUB INDICE PARA RECORRER EL POLI
			n=this.grado;
			while(j<this.grado)
			{
				acumulSucesivo=x;
				for(int i=0 ; i<n-1; i++)
				{
					acumulSucesivo*=x;
				}
				acumuladortot+=(this.coeficientes[j]*acumulSucesivo);
				acumulSucesivo=0;
				j++;
				n--;
			}
			return acumuladortot;
		}

public double evaluarRecursiva(double x ) 
{ 
	double acumuladortot=this.coeficientes[this.grado];
	int grado=this.grado;
	for(int i=0; i<this.grado ; i++)
	{
		acumuladortot+=this.coeficientes[i]*potencia(x,grado--);
	}
	return acumuladortot;
	
}
public double potencia(double x,int n)
{
	if(n==0)
		return 1;
	return x*potencia(x,n-1);
}
		public void cargarPOli()
		{
			System.out.println("Ingrese los coeficientes del polinomio ");
			Scanner reader = new Scanner(System.in);
			int i=0;
			while(i<=this.grado)
			{
				double a = reader.nextDouble();
				this.coeficientes[i]=a;
				i++;
			}
		}
		public void verPoli()
		{
			int i=0;
			int n=this.grado;
			while(i<=this.grado)
			{
				System.out.println(+this.coeficientes[i]+"x^"+n--+"+");
				i++;
			}
		}
		
		
		}


