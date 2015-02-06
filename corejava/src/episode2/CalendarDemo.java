package episode2;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo
{
	public static void main(String[] args) throws IOException, ParseException
	{
		Calendar cal = Calendar.getInstance();
		// System.out.println( "please input the day you want look up(format yyyy-MM-dd) : " );
		// BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// String dateStr = br.readLine();
		// String[] date = dateStr.split( "-" );
		// printCalendar( Integer.parseInt( date[0] ), Integer.parseInt( date[1] ), Integer.parseInt( date[2]
		// ) );
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		Date d = sdf.parse( "2015-2-21" );
		printCalendar( d );
	}


	public static void printCalendar(Date d)
	{
		Calendar c = Calendar.getInstance();
		c.setTime( d );// 
		int mon = c.get( MONTH );
		int day = c.get( DAY_OF_MONTH );
		c.set( DAY_OF_MONTH, 1 );
		int weekday = c.get( DAY_OF_WEEK );

		System.out.println( "Sun\tMon\tTue\tWed\tThu\tFri\tSat\t" );
		for ( int i = SUNDAY; i < weekday; i++ )
		{
			System.out.print( " \t" );
		}
		while (c.get( MONTH ) == mon)
		{
			if (c.get( DAY_OF_MONTH ) == day)
				System.out.print( c.get( DAY_OF_MONTH ) + "*\t" );
			else
				System.out.print( c.get( DAY_OF_MONTH ) + "\t" );
			if (c.get( DAY_OF_WEEK ) == SATURDAY)
				System.out.println();
			c.add( DAY_OF_MONTH, 1 );
		}
	}
}
