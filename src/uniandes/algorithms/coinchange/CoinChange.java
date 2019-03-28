package uniandes.algorithms.coinchange;
/**
 * Clase que modela programación dinamica CON recursion
 * @author David Hernandez y Leidy Romero
 */
public class CoinChange implements CoinChangeAlgorithm{

	private int[] monedas;

	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		monedas = new int[denominations.length];
		calculate(denominations.length,totalValue, denominations);
		calculate2(denominations.length,totalValue, denominations);
		return monedas;
	}
	//Sin min()
	public int calculate(int i, int j, int[] denominaciones)
	{
		if(j==0)
		{
			monedas[i] = 0;
		}
		else if(i == 1)
		{
			monedas[i] = j;
		}
		else if(i>1 && denominaciones[i]>j)
		{
			monedas[i] = calculate(i-1, j, denominaciones);
		}
		else if(i>1 && denominaciones[i]<=j)
		{
			monedas[i] = 1+calculate(i, j-denominaciones[i], denominaciones);
		}
		return monedas [i];
	}
	//Con min()
	public int calculate2(int i, int j, int[] denominaciones)
	{
		if(j==0)
		{
			monedas[i] = 0;
		}
		else if(i == 1)
		{
			monedas[i] = j;
		}
		else if(i>1 && denominaciones[i]>j)
		{
			monedas[i] = calculate(i-1, j, denominaciones);
		}
		else if(i>1 && denominaciones[i]<=j)
		{
			int cuentoUnaMas = 1+calculate(i, j-denominaciones[i], denominaciones);
			int disminuyoConjunto = calculate(i-1, j, denominaciones);
			if(cuentoUnaMas>disminuyoConjunto)
			{
				monedas[i] = disminuyoConjunto;
			}
			else
			{
				monedas[i] = cuentoUnaMas;
			}

		}
		return monedas [i];
	}
}

