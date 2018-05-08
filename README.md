TP2 Polinomios
Programaci´on Avanzada Trabajo Practico No 2 
Complejidad Computacional - Programacio´n dina´mica 2o cuatrimestre 2017 (ambos turnos)
DIIT - Universidad Nacional de La Matanza


1. Introducci´on
A trav´es del presente trabajo se espera que los alumnos codi?quen, evalu´en y comparen distintos algoritmos que resuelven, mediante diferentes t´ecnicas, el mismo problema.


2. Objetivos
2.1. Polinomios
Disen˜ar un programa para evaluar un polinomio P(x) de grado n.
public class Polinomio { private int grado ; private double [ ] coeficientes ; //La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n y la posicion n contiene al termino independiente .
public Polinomio {. . .} double evaluarMSucesivas (double x) {. . .} double evaluarRecursiva (double x) {. . .} double evaluarRecursivaPar (double x) {. . .} double evaluarProgDinamica (double x) {. . .} double evaluarMejorada (double x) {. . .} double evaluarPow (double x) {. . .} //y a sugerencia de Lucas P double evaluarHorner ( double x) {. . .} }

1. Escribir evaluarMSucesivas utilizando c´alculo de potencia por multiplicaciones sucesivas

2. Escribir evaluarRecursiva utilizando el siguiente c´alculo de potencia recursiva:
a) Sin considerar si el exponente es par o impar: potencia (x ,n)=x*potencia (x ,n-1) 
b) Considerando si el exponente es par o impar: Si n es par: potencia (x ,n)=potencia (x*x ,n/2) Si n es impar potencia (x ,n)=x*potencia (x ,n-1)

3. Escribir evaluarProgDinamica, almacenando las potencias de X ya calculadas.

4. Escribir evaluarMejorada, con un algoritmo de igual complejidad computacional que el anterior, pero que ejecute en un tiempo menor.

5. Escribir evaluarPow, valiendose del metodo Math.pow(x,n) provisto por el lenguaje Java. Se debe incluir dentro de alguno de los metodos anteriores donde se considere que es apropiado. Investigue la CC de Math.pow.

6. Escribir evaluarHorner, aplicando el algoritmo de Horner de an´alisis num´erico. (Investigar)

2.2. Binomio de Newton Dado un binomio de la forma (ax + b)n, conocido como elinomio de Newton, se desea:
1. Obtener el coe?ciente del t´ermino k del desarrollo de dicho binomio. Tener en cuenta que el coe?ciente k (el que corresponde al termino de xk) se calcula haciendon kakbn-k . 2. Desarrolle tambi´en, un m´etodo que permita obtener todos los coe?cientes del polinomio, o sea, el desarrollo completo del binomio, y aplique los m´etodos vistos en el punto anterior para evaluarlo en algu´n valor de x.
Desarrolle la class BinomioDeNewton, que permita cumplir con las consignas anteriores.
Nota: Investigar distintas t´ecnicas para obtener los coe?cientes del desarrollo del binomio. Estas ser´an recursivas y no recursivas. Usar t´ecnicas de programaci´on din´amica con y sin memorizaci´on. En el c´alculo de las potencias se podr´an reutilizar los m´etodos ya implementados.


3. An´alisis de complejidad computacional
Indique la funci´on de complejidada computacional asociada a cada uno de los m´etodos implementados.


4. Gr´a?cos y tablas de rendimiento comparativo
Compare el tiempo de ejecuci´on de todos los m´etodos implementados en los puntos 2.1 y 2.2
Genere todos los casos que considere necesarios para realizar el an´alisis.


5. Conclusiones
A partir de los an´alisis comparativos extraiga conclusiones.
