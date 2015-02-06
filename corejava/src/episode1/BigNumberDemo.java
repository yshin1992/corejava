package episode1;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberDemo
{
	/*
	 * ´óÊýÖµ £º BigInteger BigDecimal
	 */
	public static void main(String[] args)
	{
		BigInteger bint1 = new BigInteger( "1233344455333" );
		BigInteger bint2 = new BigInteger( "233344455333" );
		System.out.println( bint1.subtract( bint2 ) );

		BigDecimal bd1 = new BigDecimal( "122544.33" );
		BigDecimal bd2 = new BigDecimal( "122544.33" );
		System.out.println( bd1.multiply( bd2 ) );
	}

}
