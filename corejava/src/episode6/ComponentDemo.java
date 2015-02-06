package episode6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ComponentDemo extends JFrame
{
	// ComponentPanel panel;
	JPanel northPanel, centerPanel, southPanel, radioPanel;

	JLabel lable1, label2, label3;// 标签控件

	JTextField text1;// 文本控件

	JPasswordField passwd;// 密码框控件

	JTextArea area1;// 文本域控件

	JScrollPane scroll;// 滚动面板

	JFormattedTextField intField, dateField;// 格式化输入域，会有很好的效果，试试看吧

	JButton button1;// 按钮

	JCheckBox check1, check2;// 复选框

	Font font;// 字体

	ButtonGroup group;// Button组，用于合并radioButton

	JRadioButton radio1, radio2, radio3;// 单选按钮

	JComboBox<String> combox;// 组合框


	public ComponentDemo() throws ParseException
	{
		ActionListener listener = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				int mode = 0;// 字体的样式
				int size = 15;
				if (check1.isSelected())
					mode += Font.BOLD;
				if (check2.isSelected())
					mode += Font.ITALIC;
				if (radio1.isSelected())
					size = 12;
				else
					if (radio2.isSelected())
						size = 15;
					else
						size = 18;
				String fontName = "宋体";
				if (arg0.getSource() == combox)
				{
					fontName = (String) combox.getSelectedItem();
				}
				font = new Font( fontName, mode, size );
				area1.setFont( font );

			}
		};
		setLayout( new BorderLayout() );
		lable1 = new JLabel( "用户名:", JLabel.CENTER );
		text1 = new JTextField( 10 );
		label2 = new JLabel( "密码:", JLabel.CENTER );
		passwd = new JPasswordField( 10 );
		passwd.setEchoChar( '*' );// 设置回显字符
		northPanel = new JPanel();
		northPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		northPanel.add( lable1 );
		northPanel.add( text1 );
		northPanel.add( label2 );
		northPanel.add( passwd );
		add( northPanel, BorderLayout.NORTH );

		centerPanel = new JPanel();
		centerPanel.setLayout( new BorderLayout( 5, 5 ) );
		label3 = new JLabel( "用户信息:" );
		centerPanel.add( label3, BorderLayout.NORTH );
		area1 = new JTextArea( 5, 30 );
		area1.setLineWrap( true );// 在边界处换行
		area1.setTabSize( 4 );// 设置Tab的间距
		font = new Font( "宋体", Font.PLAIN, 15 );
		area1.setFont( font );
		scroll = new JScrollPane( area1 );
		centerPanel.add( scroll );
		radioPanel = new JPanel();
		radioPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		group = new ButtonGroup();
		radio1 = new JRadioButton( "SMALL" );
		radio2 = new JRadioButton( "MEDIUM", true );
		radio3 = new JRadioButton( "LARGE" );
		radio1.addActionListener( listener );
		radio2.addActionListener( listener );
		radio3.addActionListener( listener );
		group.add( radio1 );
		group.add( radio2 );
		group.add( radio3 );
		radioPanel.add( radio1 );
		radioPanel.add( radio2 );
		radioPanel.add( radio3 );

		combox = new JComboBox<String>();
		// combox.setEditable( true );
		combox.addItem( "Serif" );
		combox.addItem( "宋体" );
		combox.addItem( "楷体" );
		combox.addItem( "Dialog" );
		combox.addItem( "Times New Roman" );
		combox.addActionListener( listener );
		radioPanel.add( combox );
		centerPanel.add( radioPanel, BorderLayout.SOUTH );
		add( centerPanel, BorderLayout.CENTER );

		southPanel = new JPanel();
		// intField = new JFormattedTextField( NumberFormat.getInstance() );
		intField = new JFormattedTextField( NumberFormat.getCurrencyInstance( Locale.US ) );
		intField.setColumns( 6 );
		intField.setValue( 100 );
		southPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		southPanel.add( intField );

		MaskFormatter mf = new MaskFormatter( "####-##-##" );
		mf.setPlaceholderCharacter( '0' );
		dateField = new JFormattedTextField( mf );
		southPanel.add( dateField );
		button1 = new JButton( "显示" );
		southPanel.add( button1 );
		button1.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				StringBuilder sb = new StringBuilder();
				sb.append( "用户名: " ).append( text1.getText() ).append( "\n" );
				sb.append( "密码 : " ).append( passwd.getPassword() ).append( "\n" );
				sb.append( "数字 : " ).append( intField.getValue() ).append( "\n" );
				sb.append( "日期 : " ).append( dateField.getValue() ).append( "\n" );
				area1.setText( sb.toString() );
			}
		} );

		check1 = new JCheckBox( "Bold" );
		check1.addActionListener( listener );
		check2 = new JCheckBox( "Italic" );
		check2.addActionListener( listener );
		southPanel.add( check1 );
		southPanel.add( check2 );
		add( southPanel, BorderLayout.SOUTH );
		setTitle( "各种组件" );
		setSize( 400, 300 );
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (size.width - 400) / 2, (size.height - 230) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		try
		{
			new ComponentDemo();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

}

class ComponentPanel extends JPanel
{
	JTextField text;// 文本域

	JLabel label, lable1;// 标签


	public ComponentPanel()
	{
		text = new JTextField( 5 );
		label = new JLabel( "Label", JLabel.CENTER );
		add( text );
		add( label );
		text.addKeyListener( new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent keyevent)
			{
				if (text.getText().length() > 20)
				{
					text.setColumns( 20 );
					revalidate();
				}
			}


			@Override
			public void keyPressed(KeyEvent keyevent)
			{
				// TODO Auto-generated method stub

			}


			@Override
			public void keyReleased(KeyEvent keyevent)
			{
				// TODO Auto-generated method stub

			}

		} );
	}
}
