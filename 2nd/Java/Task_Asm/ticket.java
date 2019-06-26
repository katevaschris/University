import acm.program.*;

public class ticket extends Program
{
	public void run()
	{
		boolean flag = true;
		double sum = 0;
		double m = 0;
		double coin = 0;
		boolean check = true;

		// check the coin
		while (check)
		{
			coin = readDouble("Insert a coin...");
			if ( (coin==0.1) || (coin==0.2) || (coin==0.5) || (coin==1) || (coin==2) || (coin==5) )
			{
				sum = sum + coin;
				
			}else
			{	
				println("You gave an unacceptable coin, give anotherone");
			}
			if ((sum>price_ticket) || (sum == price_ticket)) 
				{
				 println("Here is your ticket... you gave "+ sum +" euros");
				 check = false;
				 	
				}
		}


		// change
		sum = sum - price_ticket;
		
		int two = (int) (sum / 2);
		if (two!=0)
		{
			println("You have change "+ two +" coins of 2 euros");
		}
		

		sum = sum - two * 2;
		int one = (int) (sum/ 1);
		if (one!=0)
		{
			println("You have change "+ one +" coins of 1 euros");
		} 

		sum = sum - one * 1;
		int pfive = (int) (sum / 0.5);
		if (pfive!=0)
		{
			println("You have change "+ pfive +" coins of 0.5 cents");
		}

		sum = sum - pfive * 0.5;
		int ptwo = (int) (sum / 0.2);
		if (ptwo!=0)
		{
			println("You have change "+ ptwo +" coins of 0.2 cents");
		}

		sum = sum - ptwo * 0.2;
		int pone = (int)(sum / 0.1 );
		if (pone!=0)
		{
			println("You have change "+ pone +" coins of 0.1 cents");
		}



	}
	private static final double price_ticket = 1.0;

}