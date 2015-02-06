package episode3;

import java.lang.reflect.Array;

public class ArrayGrowDemo
{

	public static void main(String[] args)
	{
		int[] a = { 1, 2, 3 };
		a = (int[]) arrayGrow( a );
		arrayPrint( a );

		String[] b = { "Tom", "Dick", "Harry" };
		b = (String[]) arrayGrow( b );
		arrayPrint( b );
	}


	static Object arrayGrow(Object a)
	{
		Class c = a.getClass();
		if (!c.isArray())
			return null;
		Class comptype = c.getComponentType();
		int length = Array.getLength( a );
		int newLength = length * 11 / 10 + 10;
		Object newArray = Array.newInstance( comptype, newLength );// 创建一个数组
		System.arraycopy( a, 0, newArray, 0, length );
		return newArray;
	}


	static void arrayPrint(Object a)
	{
		Class c = a.getClass();
		if (!c.isArray())
			return;
		Class comptype = c.getComponentType();
		int length = Array.getLength( a );
		System.out.println( comptype.getName() + "[" + length + "]={" );
		for ( int i = 0; i < length; i++ )
			System.out.print( Array.get( a, i ) + " " );// get(Object array, int index) 返回指定数组对象中索引组件的值
		System.out.println( "}" );
	}
}