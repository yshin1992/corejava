package episode6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame
{

	JButton north, south, center, west, east;


	/*
	 * 边界布局管理器
	 */

	public BorderLayoutDemo()
	{
		setTitle( "边界布局管理器" );
		setSize( 400, 230 );
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (size.width - 400) / 2, (size.height - 230) / 2 );
		setLayout( new BorderLayout() );
		north = new JButton( "North" );
		south = new JButton( "South" );
		west = new JButton( "West" );
		east = new JButton( "East" );
		center = new JButton( "Center" );
		add( north, BorderLayout.NORTH );
		add( south, BorderLayout.SOUTH );
		add( west, BorderLayout.WEST );
		add( east, BorderLayout.EAST );
		add( center, BorderLayout.CENTER );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new BorderLayoutDemo();
	}

}
