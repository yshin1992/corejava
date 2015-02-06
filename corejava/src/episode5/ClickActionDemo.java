package episode5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickActionDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new ClickFrame();
	}

}

class ClickFrame extends JFrame
{
	private static final int WIDTH = 300;

	private static final int HEIGHT = 200;


	public ClickFrame()
	{
		this.setTitle( "A Click Demo" );
		this.setSize( WIDTH, HEIGHT );
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation( (screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2 );

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

		ClickJPanel spanel = new ClickJPanel();
		add( spanel );

		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}

}

class ClickJPanel extends JPanel
{
	private JButton btn1, btn2, btn3;


	public ClickJPanel()
	{
		btn1 = new JButton( "Blue" );
		btn2 = new JButton( "Yellow" );
		btn3 = new JButton( "Red" );
		btn1.addActionListener( new ColorAction( Color.blue ) );
		btn2.addActionListener( new ColorAction( Color.yellow ) );
		btn3.addActionListener( new ColorAction( Color.red ) );
		add( btn1 );
		add( btn2 );
		add( btn3 );
	}

	class ColorAction implements ActionListener
	{
		private Color color;


		public ColorAction(Color color)
		{
			this.color = color;
		}


		@Override
		public void actionPerformed(ActionEvent actionevent)
		{
			ClickJPanel.this.setBackground( color );
		}
	}
}
