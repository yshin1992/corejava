package episode7;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConsoleWindowTest extends JFrame
{
	JPanel panel;

	JButton btn1, btn2, btn3;


	public ConsoleWindowTest()
	{
		panel = new JPanel();
		btn1 = new JButton( new ColorAction( "Yellow" ) );
		btn2 = new JButton( new ColorAction( "Red" ) );
		btn3 = new JButton( new ColorAction( "Blue" ) );
		panel.add( btn1 );
		panel.add( btn2 );
		panel.add( btn3 );
		add( panel );
		setTitle( "Console Window Test Frame" );
		setSize( 300, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		// 显示控制台
		ConsoleWindow.init();
	}


	public static void main(String[] args)
	{
		new ConsoleWindowTest();
	}

	class ColorAction extends AbstractAction
	{
		private String color;


		public ColorAction(String color)
		{
			this.color = color;
			putValue( Action.NAME, color );
		}


		@Override
		public void actionPerformed(ActionEvent actionevent)
		{
			System.out.println( color );
		}
	}

}
