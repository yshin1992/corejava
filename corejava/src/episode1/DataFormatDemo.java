package episode1;

import java.util.Date;

public class DataFormatDemo
{

	public static void main(String[] args)
	{
		String name = "Jane";
		int age = 22;
		String formatmsg = String.format( "Hello %s, the next year you will be %d\n", name, age );
		System.out.println( formatmsg );
		System.out.printf( "%tc", new Date() );
	}
}
