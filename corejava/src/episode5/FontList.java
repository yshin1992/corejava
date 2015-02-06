package episode5;

import java.awt.GraphicsEnvironment;

public class FontList
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for ( String font : fontNames )
		{
			System.out.println( font );
		}
	}

}
