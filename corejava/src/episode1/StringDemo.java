package episode1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringDemo
{

	/*
	 * 从List中取出姓名以'张'开头的用户，并从中移除
	 */
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add( "张飞" );
		list.add( "赵云" );
		list.add( "吕布" );
		list.add( "刘备" );
		list.add( "张辽" );
		/*
		 * 第一种方式，不借用迭代器
		 */
		// for ( int i = 0; i < list.size(); i++ )
		// {
		// if (list.get( i ).startsWith( "张" ))
		// {
		// list.remove( i );
		// i--;
		// }
		// }

		/*
		 * 第二种方式，使用迭代器Iterator
		 */
		for ( Iterator<String> it = list.iterator(); it.hasNext(); )
		{
			if (it.next().startsWith( "张" ))
			{
				it.remove();
			}
		}

		for ( Iterator<String> it = list.iterator(); it.hasNext(); )
		{
			System.out.println( it.next() );
		}
		/*
		 * 以下代码请细细斟酌
		 */
		String str = "";
		String[] strs = str.split( "," );
		System.out.println( strs.length );

	}
}
