package episode1;

import java.util.Arrays;

public class ArrayDemo
{
	/*
	 * Java数组 注意 Java实质上没有多维数组，多维数组就是数组的数组
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

		/* 数组的复制 */
		int[] aint = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] bint = new int[6];
		System.arraycopy( aint, 3, bint, 0, 6 );
		for ( int i = 0; i < 6; i++ )
		{
			System.out.print( bint[i] + "\t" );
		}
		/*
		 * 数组的排序
		 */
		System.out.println( "\nThe Array Before Sort: " );
		int[] b = new int[10];
		// 产生10个随机数
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

		// 数组的搜索
		int temp = (int) Math.round( Math.random() * 100 );
		b[0] = 0;
		int index = Arrays.binarySearch( b, 0 );// 当其查找到该值时返回数组的下标，否则返回一个负数
		if (index >= 0)
		{
			System.out.println( "We search your requested number : " + 0 );
		}
		// 初始化数组
		byte[] bit = new byte[10];
		Arrays.fill( bit, (byte) -1 );
		byte[] bit2 = new byte[10];
		Arrays.fill( bit2, (byte) -1 );
		System.out.println( "The two arrays is equal?" + Arrays.equals( bit, bit2 ) );
	}
}