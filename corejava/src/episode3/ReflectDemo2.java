package episode3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo2
{

	public static void main(String[] args) throws Exception, IllegalAccessException
	{
		// 获得Employee的class
		Class<?> c = Employee.class;
		Method[] methods = c.getDeclaredMethods();
		Object obj = c.newInstance();
		for ( Method method : methods )
		{
			// 假定此方法是setter方法
			if (method.getName().startsWith( "set" ))
			{
				Class<?>[] params = method.getParameterTypes();
				String type = params[0].getSimpleName();
				if ("int".equals( type ))
				{
					method.invoke( obj, 18 );
				}
				else
					if ("String".equals( type ))
					{
						method.invoke( obj, "Jane" );
					}
			}
		}

		for ( Method method : methods )
		{
			// 假定此方法是setter方法
			if (method.getName().startsWith( "get" ))
			{
				System.out.println( method.invoke( obj, null ) );
			}
		}
		Method sayMethod = c.getDeclaredMethod( "sayHello", null );
		sayMethod.invoke( obj, null );

		Field field = c.getDeclaredField( "age" );
		field.setAccessible( true );// 必须设置为true，否则会报异常can not access a member of...
		System.out.println( field.get( obj ) );
	}
}

class Employee
{
	private int age;

	private String name;


	public Employee()
	{

	}


	public Employee(String name, int age)
	{
		this.name = name;
		this.age = age;
	}


	public int getAge()
	{
		return age;
	}


	public String getName()
	{
		return name;
	}


	public void setAge(int age)
	{
		this.age = age;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public void sayHello()
	{
		System.out.println( "Hello,I'm " + this.name + " , age is " + this.age );
	}

}