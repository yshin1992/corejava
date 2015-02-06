package episode1;

import java.util.Arrays;

public class ArrayDemo
{
	/*
	 * Java���� ע�� Javaʵ����û�ж�ά���飬��ά����������������
	 */
	public static void main(String[] args)
	{
		int[][] intarray = new int[4][];
		intarray[0] = new int[] { 3, 3, 4, 4, 44, 44, 444, 444 };
		intarray[1] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		intarray[2] = new int[] { 22, 33, 44, 55 };
		intarray[3] = new int[] { 22, 11 };
		for ( int i = 0; i < intarray.length; i++ )
		{
			for ( int j = 0; j < intarray[i].length; j++ )
			{
				System.out.print( intarray[i][j] + "\t" );
			}
			System.out.println();
		}

		/* ����ĸ��� */
		int[] aint = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] bint = new int[6];
		System.arraycopy( aint, 3, bint, 0, 6 );
		for ( int i = 0; i < 6; i++ )
		{
			System.out.print( bint[i] + "\t" );
		}
		/*
		 * ���������
		 */
		System.out.println( "\nThe Array Before Sort: " );
		int[] b = new int[10];
		// ����10�������
		for ( int i = 0; i < 10; i++ )
		{
			b[i] = (int) Math.round( Math.random() * 100 );
			System.out.print( b[i] + "\t" );
		}
		System.out.println( "\nThe array after sort :" );
		Arrays.sort( b );
		for ( int temp : b )
		{
			System.out.print( temp + "\t" );
		}

		// ���������
		int temp = (int) Math.round( Math.random() * 100 );
		b[0] = 0;
		int index = Arrays.binarySearch( b, 0 );// ������ҵ���ֵʱ����������±꣬���򷵻�һ������
		if (index >= 0)
		{
			System.out.println( "We search your requested number : " + 0 );
		}
		// ��ʼ������
		byte[] bit = new byte[10];
		Arrays.fill( bit, (byte) -1 );
		byte[] bit2 = new byte[10];
		Arrays.fill( bit2, (byte) -1 );
		System.out.println( "The two arrays is equal?" + Arrays.equals( bit, bit2 ) );
	}
}