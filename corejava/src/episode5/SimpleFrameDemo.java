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

public class SimpleFrameDemo
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		new SimpleFrame();
	}

}

class SimpleFrame extends JFrame
{
	public SimpleFrame() throws IOException
	{
		this.setTitle( "A Simple Demo" );
		this.setSize( WIDTH, HEIGHT );
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation( (screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2 );

		// Image img = kit.getImage( "img/win.png" );
		Image img = ImageIO.read( new File( "img/win.png" ) );
		setIconImage( img );// 此方法失效

		spanel = new SimplePanel();
		add( spanel );

		setVisible( true );

		// setExtendedState( MAXIMIZED_BOTH );// 将框架调整到最大
		setDefaultCloseOperation( EXIT_ON_CLOSE );

		// toFront();// 放置最前面
		toBack();// 放置到后面，重新排列窗口

	}

	private static final int WIDTH = 300;

	private static final int HEIGHT = 200;

	private SimplePanel spanel;
}

class SimplePanel extends JPanel
{

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		g.drawString( "This is a  simple panel", 20, 20 );
	}

}
