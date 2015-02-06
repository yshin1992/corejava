package episode5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawImageDemo extends JFrame
{
	private DrawImageDemo2 draw;

	public static final int WIDTH = 420;

	public static final int HEIGHT = 390;


	public DrawImageDemo()
	{
		this.setTitle( "绘制图形的JFrame" );
		this.setSize( WIDTH, HEIGHT );
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation( (screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2 );

		draw = new DrawImageDemo2();
		add( draw );

		// Image img = kit.getImage( "img/win.png" );
		Image img;
		try
		{
			img = ImageIO.read( new File( "img/win.png" ) );
			setIconImage( img );// 此方法失效
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new DrawImageDemo();
	}

}

class DrawImageDemo2 extends JPanel
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		try
		{
			Image img = ImageIO.read( new File( "img/win.png" ) );
			if (img == null)
				return;
			int width = img.getWidth( null );
			int height = img.getHeight( null );
			g.drawImage( img, 0, 0, null );
			for ( int i = 0; i * width <= getWidth(); i++ )
				for ( int j = 0; j * height < getHeight(); j++ )
				{
					if (i + j > 0)
						g.copyArea( 0, 0, width, height, i * width, j * height );
				}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
