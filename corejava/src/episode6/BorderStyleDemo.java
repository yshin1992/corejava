package episode6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderStyleDemo extends JFrame
{
	public static final int WIDTH = 600;

	public static final int HEIGHT = 200;

	private JPanel demoPanel, buttonPanel;

	private ButtonGroup group;


	public BorderStyleDemo()
	{
		setTitle( "BorderStyleDemo" );
		setLayout( new GridLayout( 2, 1 ) );
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		addRadioButton( "Lowered bevel", BorderFactory.createLoweredBevelBorder() );// 创建一个凹面效果的边界
		addRadioButton( "Lowered soft bevel", BorderFactory.createLoweredSoftBevelBorder() );// 创建一个凸面效果的边界
		addRadioButton( "Raised bevel", BorderFactory.createRaisedBevelBorder() );
		addRadioButton( "Raised soft bevel", BorderFactory.createRaisedSoftBevelBorder() );
		addRadioButton( "Etched", BorderFactory.createEtchedBorder() );// 创建一个具有3D效果的边界
		addRadioButton( "Line", BorderFactory.createLineBorder( Color.red ) );// 创建一条直线边界
		addRadioButton( "Matte", BorderFactory.createMatteBorder( 10, 2, 8, 5, Color.red ) );// 创建一个粗边界
		addRadioButton( "Empty", BorderFactory.createEmptyBorder() );

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder( etched, "Border Types" );
		buttonPanel.setBorder( titled );
		add( buttonPanel );
		demoPanel = new JPanel();
		add( demoPanel );
		setSize( WIDTH, HEIGHT );
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (size.width - WIDTH) / 2, (size.height - HEIGHT) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new BorderStyleDemo();
	}


	public void addRadioButton(String name, final Border b)
	{
		JRadioButton button = new JRadioButton( name );
		button.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				demoPanel.setBorder( b );
				validate();
			}
		} );
		group.add( button );
		buttonPanel.add( button );
	}
}
