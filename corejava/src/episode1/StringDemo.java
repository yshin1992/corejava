package episode1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringDemo
{

	/*
	 * ��List��ȡ��������'��'��ͷ���û����������Ƴ�
	 */
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add( "�ŷ�" );
		list.add( "����" );
		list.add( "����" );
		list.add( "����" );
		list.add( "����" );
		/*
		 * ��һ�ַ�ʽ�������õ�����
		 */
		// for ( int i = 0; i < list.size(); i++ )
		// {
		// if (list.get( i ).startsWith( "��" ))
		// {
		// list.remove( i );
		// i--;
		// }
		// }

		/*
		 * �ڶ��ַ�ʽ��ʹ�õ�����Iterator
		 */
		for ( Iterator<String> it = list.iterator(); it.hasNext(); )
		{
			if (it.next().startsWith( "��" ))
			{
				it.remove();
			}
		}

		for ( Iterator<String> it = list.iterator(); it.hasNext(); )
		{
			System.out.println( it.next() );
		}
		/*
		 * ���´�����ϸϸ����
		 */
		String str = "";
		String[] strs = str.split( "," );
		System.out.println( strs.length );

	}
}
