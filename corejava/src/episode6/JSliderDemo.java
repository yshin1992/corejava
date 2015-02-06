package episode6;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderDemo extends JFrame
{
	JPanel panel;

	JTextField textField;

	ChangeListener listener;


	public void addSlider(JSlider s, String desc)
	{
		s.addChangeListener( listener );
		JPanel pan = new JPanel();
		pan.add( s );
		pan.add( new JLabel( desc ) );
		panel.add( pan );
	}


	public JSliderDemo()
	{
		panel = new JPanel();
		// slider1=new JSlider();//创建一个范围在 0 到 100 之间并且初始值为 50 的水平滑块
		// slider1 = new JSlider( 0, 100, 10 );// 用指定的最小值、最大值和初始值创建一个水平滑块
		// slider1 = new JSlider( JSlider.VERTICAL );// 使用指定的方向创建一个滑块，范围在 0 到 100 之间并且初始值为 50。
		// slider1 = new JSlider( 20, 130 );// 使用指定的最小值和最大值创建一个水平滑块，初始值等于最小值加上最大值的平均值。
		// slider1=new JSlider(JSlider.VERTICAL,0,100,23);//用指定的方向和指定的最小值、最大值以及初始值创建一个滑块
		// panel.add( slider1 );
		panel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		listener = new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				JSlider source = (JSlider) arg0.getSource();
				textField.setText( source.getName() + ":" + source.getValue() );
			}
		};
		// add a plain slider
		JSlider slider = new JSlider();
		addSlider( slider, "Plain" );

		// add a slider with major and minor ticks
		slider = new JSlider();
		slider.setPaintTicks( true );// 显示刻度必须要加上这句
		slider.setMajorTickSpacing( 20 );
		slider.setMinorTickSpacing( 5 );
		addSlider( slider, "Ticks" );

		// add a slider that snaps to ticks
		slider = new JSlider();
		slider.setPaintTicks( true );// 显示刻度必须要加上这句
		slider.setSnapToTicks( true );// 指定为 true，则滑块（及其所表示的值）解析为最靠近用户放置滑块处的刻度标记的值。
		slider.setMajorTickSpacing( 20 );
		slider.setMinorTickSpacing( 5 );
		addSlider( slider, "Snap to ticks" );

		// add a slider with no track
		slider = new JSlider();
		slider.setPaintTicks( true );// 显示刻度必须要加上这句,确定是否在滑块上刻度标记。
		slider.setMajorTickSpacing( 20 );
		slider.setMinorTickSpacing( 5 );
		slider.setPaintTrack( false );// 确定是否在滑块上绘制滑道。
		addSlider( slider, "no track" );

		// add a inverted slider
		slider = new JSlider();
		slider.setPaintTicks( true );// 显示刻度必须要加上这句,确定是否在滑块上刻度标记。
		slider.setMajorTickSpacing( 20 );
		slider.setMinorTickSpacing( 5 );
		slider.setInverted( true );
		addSlider( slider, "Inverted" );// 指定为 true，则反转滑块显示的值范围，指定为 false 则将值范围置为正常顺序

		// add a slider with alphabetic label
		slider = new JSlider();
		slider.setPaintTicks( true );// 显示刻度必须要加上这句,确定是否在滑块上刻度标记。
		slider.setPaintLabels( true );// 确定是否在滑块上绘制标签
		slider.setMajorTickSpacing( 20 );
		slider.setMinorTickSpacing( 5 );
		Dictionary<Integer, Component> labelTables = new Hashtable<Integer, Component>();
		labelTables.put( 0, new JLabel( "A" ) );
		labelTables.put( 20, new JLabel( "B" ) );
		labelTables.put( 40, new JLabel( "C" ) );
		labelTables.put( 60, new JLabel( "D" ) );
		labelTables.put( 80, new JLabel( "E" ) );
		labelTables.put( 100, new JLabel( "F" ) );
		slider.setLabelTable( labelTables );// 用于指定将在给定值处绘制哪个标签。
		addSlider( slider, "Custom labels" );
		setLayout( new BorderLayout() );
		add( panel, BorderLayout.CENTER );
		textField = new JTextField();
		add( textField, BorderLayout.SOUTH );
		setVisible( true );
		// pack();
		setSize( 450, 350 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new JSliderDemo();
	}

}
