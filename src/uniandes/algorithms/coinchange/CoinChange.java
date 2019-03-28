package uniandes.algorithms.coinchange;

public class CoinChange implements CoinChangeAlgorithm{
	
	private int[] monedas;

	public int[] calculateOptimalChange(int totalValue, int[] denominations) {

		if(denominations.length == 0 || totalValue == 0) return null;

		else if(denominations[denominations.length]<=totalValue) 
		{
			//TODO less???
			calculateOptimalChange(totalValue, getAux(denominations, getNewSize(denominations.length)));
			calculateOptimalChange(totalValue-denominations[denominations.length], denominations); 
		}
		else 
		{
			calculateOptimalChange(totalValue, getAux(denominations, getNewSize(denominations.length)));
		}
	}
	//TODO revisar
	public int getNewSize(int size)
	{
		return size--;
	}
	//TODO revisar
	public int[] getAux(int[] denominaciones, int N)
	{
		int[] aux = new int[N];
		//aux=denominaciones;
		for(int i = 0; i<N;i++)
		{
			aux[i]=denominaciones[i];
		}
		return aux;
	}
	public void addCoin()
	{

	}
}

