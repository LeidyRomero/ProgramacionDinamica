package uniandes.algorithms.coinchange;
/**
 * Clase que modela VORAZ: DIVISION
 * @author David Hernandez y Leidy Romero
 */
public class CoinChangeGreedy implements CoinChangeAlgorithm{
	private int[] monedas;

	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		monedas = new int[denominations.length];
		calculate(denominations.length, totalValue, denominations);
		return monedas;
	}
	public void calculate(int i, int j, int[] denominaciones)
	{
		while(i>=0)
		{
			if(denominaciones[i]<=j)
			{
				monedas[i] = j/denominaciones[i];
				j-=monedas[i]*denominaciones[i];
			}
			i--;
		}
	}
}

