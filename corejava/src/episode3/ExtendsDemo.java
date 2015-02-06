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
	// ע�⸸������ʽ�޲ι��캯����������
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