package episode5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ColorActionDemo extends JFrame
{
	public ColorActionDemo()
	{
		setTitle( "keyListener Demo" );
		setSize( 400, 300 );
		ColorActionPanel panel = new ColorActionPanel();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

	}


	public static void main(String[] args)
	{
		new ColorActionDemo();
	}

}

class ColorActionPanel extends JPanel
{
	private JButton btn1, btn2, btn3;


	public ColorActionPanel()
	{
		ColorAction yellow = new ColorAction( "Yellow", Color.yellow );
		ColorAction blue = new ColorAction( "Blue", Color.blue );
		ColorAction red = new ColorAction( "Red", Color.red );
		red.setEnabled( false );
		btn1 = new JButton( yellow );
		btn2 = new JButton( blue );
		btn3 = new JButton( red );
		add( btn1 );
		add( btn2 );
		add( btn3 );
		// 注册加速键
		InputMap imap = this.getInputMap();
		imap.put( KeyStroke.getKeyStroke( "ctrl B" ), "panel.blue" );
		imap.put( KeyStroke.getKeyStroke( "ctrl Y" ), "panel.yellow" );
		imap.put( KeyStroke.getKeyStroke( "ctrl R" ), "panel.red" );
		ActionMap amap = this.getActionMap();
		amap.put( "panel.blue", blue );
		amap.put( "panel.red", red );
		amap.put( "panel.yellow", yellow );
	}

	class ColorAction extends AbstractAction
	{

		public ColorAction(String name, Color c)
		{
			putValue( Action.NAME, name );
			putValue( "Color", c );
			putValue( Action.SHORT_DESCRIPTION, "set Panel Color to " + name.toLowerCase() );
		}


		@Override
		public void actionPerformed(ActionEvent actionevent)
		{
			// TODO Auto-generated method stub
			Color c = (Color) getValue( "Color" );
			setBackground( c );
		}

	}
}