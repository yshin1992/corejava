package episode3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectDemo
{
	static void change(String str)
	{
		try
		{
			Class<?> clazz = str.getClass();
			Field field = clazz.getDeclaredField( "value" );
			field.setAccessible( true );
			Object obj = field.get( str );
			char[] charValue = (char[]) obj;
			charValue = new char[3];
			for ( int i = 0; i < charValue.length; i++ )
			{
				charValue[i] = 'a';
			}
			field.set( str, charValue );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	static void change(SelfReflectDemo reflectdemo)
	{
		reflectdemo.setCount( 10 );
		reflectdemo.size = 1;
	}


	public static void main(String[] args)
	{
		try
		{
			reflect( "java.lang.String" );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void reflect(String className) throws Exception
	{
		StringBuilder str = new StringBuilder();
		Class c = Class.forName( className );
		int classModifers = c.getModifiers();// 类的修饰符
		str.append( Modifier.toString( classModifers ) ).append( " class " ).append( c.getSimpleName() );

		Class superclass = c.getSuperclass();
		Class[] interfaces = c.getInterfaces();

		str.append( " extends " ).append( superclass.getSimpleName() ).append( " implements " );
		for ( int i = 0; i < interfaces.length - 1; i++ )
		{
			str.append( interfaces[i].getSimpleName() + "," );
		}
		if (interfaces.length > 0)
			str.append( interfaces[interfaces.length - 1].getSimpleName() + "{\n" );
		else
			str.append( " {\n " );

		// 属性
		Field[] fields = c.getDeclaredFields();
		for ( Field f : fields )
		{
			// 在java的反射使用中,如果字段是私有的,那么必须要对这个字段设置field.setAccessible(true)这样才可以正常使用.否则或报错:can not access a
			// member of.......
			int modifiers = f.getModifiers();
			Class type = f.getType();
			// System.out.println( Modifier.toString( modifiers ) + " " + type.getName() + " " + f.getName()
			// );
			str.append( "\t" ).append( Modifier.toString( modifiers ) ).append( " " ).append( type.getSimpleName() ).append( " " ).append( f.getName() ).append( ";\n" );
		}

		// 构造函数
		Constructor[] constructors = c.getConstructors();
		for ( Constructor constructor : constructors )
		{
			int modifiers = constructor.getModifiers();
			Class[] parameters = constructor.getParameterTypes();
			Class[] exceptions = constructor.getExceptionTypes();
			str.append( "\t" ).append( Modifier.toString( modifiers ) ).append( " " ).append( constructor.getName() ).append( "( " );
			for ( int i = 0; i < parameters.length - 1; i++ )
			{
				str.append( parameters[i].getSimpleName() ).append( "," );
			}
			if (parameters.length > 0)
				str.append( parameters[parameters.length - 1].getSimpleName() );
			str.append( " )" );
			if (exceptions.length > 0)
				str.append( "throws " );
			for ( int i = 0; i < exceptions.length - 1; i++ )
			{
				str.append( exceptions[i].getSimpleName() ).append( "," );
			}
			if (exceptions.length > 0)
				str.append( exceptions[exceptions.length - 1].getSimpleName() );
			str.append( "{ }\n" );
		}
		// 方法
		Method[] methods = c.getDeclaredMethods();
		for ( Method m : methods )
		{
			int modifiers = m.getModifiers();// 修饰符
			Class type = m.getReturnType();// 返回类型
			Class[] parameters = m.getParameterTypes();
			Class[] exceptions = m.getExceptionTypes();
			str.append( "\t" ).append( Modifier.toString( modifiers ) ).append( " " ).append( type.getSimpleName() ).append( " " ).append( m.getName() ).append( "( " );
			for ( int i = 0; i < parameters.length - 1; i++ )
			{
				str.append( parameters[i].getSimpleName() ).append( "," );
			}
			if (parameters.length > 0)
				str.append( parameters[parameters.length - 1].getSimpleName() );
			str.append( " )" );
			if (exceptions.length > 0)
				str.append( "throws " );
			for ( int i = 0; i < exceptions.length - 1; i++ )
			{
				str.append( exceptions[i].getSimpleName() ).append( "," );
			}
			if (exceptions.length > 0)
				str.append( exceptions[exceptions.length - 1].getSimpleName() );
			str.append( "{ }\n" );
		}
		str.append( "}" );
		System.out.println( str );
	}
}

class SelfReflectDemo
{
	private int count;

	public int size = 0;


	public SelfReflectDemo()
	{

	}


	public int getCount()
	{
		return count;
	}


	public void setCount(int count)
	{
		this.count = count;
	}

}