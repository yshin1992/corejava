package episode2;

public class StaticMethodFiledDemo
{

	public static void main(String[] args)
	{
		for ( int i = 0; i < 10; i++ )
		{
			new Student( "Student" + i );
		}
		System.out.println( "student count : " + Student.count );
	}
}

class Student
{
	String name;

	{
		System.out.println( "初始化块(非静态)" );
	}

	static int count;
	static
	{
		/*
		 * 静态初始化块会在普通初始化执行之前执行，并且只执行一次
		 */
		System.out.println( "Student class load!" );
		count = 0;
	}


	public Student(String name)
	{
		this.name = name;
		count++;
	}
}