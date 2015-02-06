package episode3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class AnalayzObjectDemo
{

	public static void main(String[] args)
	{
		ArrayList<Integer> squares = new ArrayList<Integer>();
		for ( int i = 1; i <= 5; i++ )
		{
			squares.add( i * i );
		}
		Analayzer analyzer = new Analayzer();
		System.out.println( analyzer.toString( squares ) );
		System.out.println( "------------------------------------------------------------------------------------------------------" );
		System.out.println( analyzer.toString( new String[] { "hello", "jane" } ) );
	}

}

class Analayzer
{
	private ArrayList<Object> visited = new ArrayList<Object>();


	public String toString(Object obj)
	{

		if (obj == null)
			return "null";
		if (visited.contains( obj ))
			return "...";
		visited.add( obj );
		Class c1 = obj.getClass();
		if (c1 == String.class)
			return (String) obj;

		if (c1.isArray())
		{
			String r = c1.getComponentType() + "[]{";// 得到数组的组件类型
			for ( int i = 0; i < Array.getLength( obj ); i++ )// 得到数组的长度
			{
				if (i > 0)
					r += ",";
				Object val = Array.get( obj, i );
				if (c1.getComponentType().isPrimitive())// 判定指定的 Class 对象是否表示一个基本类型
					r += val;
				else
					r += toString( val );
			}
			return r + "}";
		}

		String r = c1.getSimpleName();
		// inspect the fields of this class and all superclasses
		do
		{
			r += "[";
			Field[] fields = c1.getDeclaredFields();// 得到obj对象的所有属性，并罗列出来
			AccessibleObject.setAccessible( fields, true );

			for ( Field f : fields )
			{
				if (!Modifier.isStatic( f.getModifiers() ))// 当其不是静态成员时
				{
					if (!r.endsWith( "[" ))
						r += ",";// 循环，当再次碰到不以"["结尾时，添加","以分割每个属性的具体类型和值
					r += f.getName() + "=";
					try
					{
						Class t = f.getType();
						Object val = f.get( obj );// 得到该值
						if (t.isPrimitive())
							r += val;
						else
							r += toString( val );// 当其不是基本类型时，递归调用此函数获得其内部的属性和值
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			r += "]";
			c1 = c1.getSuperclass();
		} while (c1 != null);

		return r;
	}
}