package episode6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridLayoutDemo extends JFrame
{

	private JPanel panel1, panel2;

	private JLabel label;

	private JButton[] btns;


	/*
	 * 网格布局管理器
	 */

	public void init()
	{
		panel1 = new JPanel();
		label = new JLabel( "0.0" );
		panel1.add( label );
		panel2 = new JPanel();
		btns = new JButton[16];
		for ( int i = 0; i < 10; i++ )
		{
			btns[i] = new JButton( i + "" );
		}
		btns[10] = new JButton( "+" );
		btns[11] = new JButton( "-" );
		btns[12] = new JButton( "*" );
		btns[13] = new JButton( "/" );
		btns[14] = new JButton( "." );
		btns[15] = new JButton( "=" );
		panel2.setLayout( new GridLayout( 4, 4 ) );
		for ( int i = 1; i < 4; i++ )
			panel2.add( btns[i] );
		panel2.add( btns[10] );
		for ( int i = 4; i < 7; i++ )
			panel2.add( btns[i] );
		panel2.add( btns[11] );
		for ( int i = 7; i < 10; i++ )
			panel2.add( btns[i] );
		panel2.add( btns[12] );
		panel2.add( btns[0] );
		panel2.add( btns[13] );
		panel2.add( btns[14] );
		panel2.add( btns[15] );
	}


	public GridLayoutDemo()
	{
		setTitle( "边界布局管理器" );
		setSize( 400, 300 );
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (size.width - 400) / 2, (size.height - 300) / 2 );
		setLayout( new BorderLayout() );
		init();
		add( panel1, BorderLayout.NORTH );
		add( panel2, BorderLayout.CENTER );
		setVisible( true );
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new GridLayoutDemo();
	}

}
