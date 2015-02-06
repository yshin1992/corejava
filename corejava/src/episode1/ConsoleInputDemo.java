package episode1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInputDemo
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner( System.in );
		System.out.println( "Please input first number : " );
		int num1 = sc.nextInt();
		System.out.println( "Please input second number : " );
		int num2 = sc.nextInt();
		System.out.println( "two number add result : " + (num1 + num2) );

		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.println( "Please input characters to reverse : " );
		String str = br.readLine();
		System.out.println( "The characters after reverse : " + new StringBuffer( str ).reverse().toString() );
		br.close();
	}
}
