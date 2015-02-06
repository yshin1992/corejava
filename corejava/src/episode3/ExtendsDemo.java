package episode3;

public class ExtendsDemo
{

	public static void main(String[] args)
	{
		Animal[] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Cat();
		// animal[0].shout();
		// animal[1].shout();
		System.out.println( animal[0] instanceof Cat );
		System.out.println( animal[1] instanceof Cat );
	}
}

class Animal
{
	public Animal()
	{
		System.out.println( "The Animal created!" );
	}


	public void shout()
	{
		System.out.println( "The Animal shout!" );
	}
}

class Dog extends Animal
{
	// 注意父类无显式无参构造函数会编译出错
	public Dog()
	{
		System.out.println( "Dog is created" );
	}


	@Override
	public void shout()
	{
		System.out.println( "Wang Wang Wang" );
	}
}

class Cat extends Animal
{
	public Cat()
	{
		System.out.println( "Cat is created" );
	}


	@Override
	public void shout()
	{
		System.out.println( "Miao Miao Miao" );
	}
}