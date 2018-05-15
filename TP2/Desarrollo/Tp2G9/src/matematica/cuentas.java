package matematica;

import org.junit.Assert;

public class cuentas {

	public static void main(String[] args) {

		Polinomio poli = new Polinomio(100000);

		double i;
		poli.cargarconVector();
		long starttime = System.currentTimeMillis();
		i = poli.evaluarHorner(2);
		long endtime = System.currentTimeMillis() - starttime;
		System.out.println(endtime);

	}
}
