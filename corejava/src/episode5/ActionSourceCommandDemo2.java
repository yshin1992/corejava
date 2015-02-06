package episode5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionSourceCommandDemo2 extends JFrame
{
	public ActionSourceCommandDemo2()
	{
		setTitle( "通过getSource区分事件源" );
		setSize( 300, 200 );
		ActionCommandPanel2 panel = new ActionCommandPanel2();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

	}


	/*
	 * 使用actionCommand区分事件源
	 */

	public static void main(String[] args)
	{
		new ActionSourceCommandDemo2();
	}

}

class ActionCommandPanel2 extends JPanel implements ActionListener
{
	private JButton btn1, btn2, btn3;


	public ActionCommandPanel2()
	{
		btn1 = new JButton( "Blue" );
		btn2 = new JButton( "Yellow" );
		btn3 = new JButton( "Red" );

		btn1.addActionListener( this );
		btn2.addActionListener( this );
		btn3.addActionListener( this );

		add( btn1 );
		add( btn2 );
		add( btn3 );

	}


	@Override
	public void actionPerformed(ActionEvent actionevent)
	{
		String actionCommand = actionevent.getActionCommand();
		if ("Blue".equals( actionCommand ))
		{
			setBackground( Color.blue );
		}
		else
			if ("Yellow".equals( actionCommand ))
			{
				setBackground( Color.yellow );
			}
			else
			{
				setBackground( Color.red );
			}

	}
}
