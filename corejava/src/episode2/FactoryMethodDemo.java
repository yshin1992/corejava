package episode2;

import java.text.NumberFormat;
import java.util.Locale;

public class FactoryMethodDemo
{
	/*
	 * 工厂模式的方法，常见的是Calendar.getInstance();
	 */
	public static void main(String[] args)
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance( Locale.CANADA );
		NumberFormat percent = NumberFormat.getPercentInstance();
		double d1 = 122.34;
		System.out.println( currency.format( d1 ) );
		System.out.println( percent.format( d1 ) );
	}

}
