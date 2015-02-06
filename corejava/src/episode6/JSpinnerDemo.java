package episode6;

import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class JSpinnerDemo extends JFrame
{
	JSpinner spinner;// 微调器

	JPanel panel;


	public JSpinnerDemo()
	{
		panel = new JPanel();
		panel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		panel.add( new JLabel( "Default JSpinner" ) );
		// Default
		spinner = new JSpinner();// 构造一个 spinner，使其具有初始值为 0 并且无任何最小值或者最大值限制的 Integer SpinnerNumberModel。
		panel.add( spinner );

		// JSpinner with a default value,minValue/maxValue and step
		spinner = new JSpinner( new SpinnerNumberModel( 1, 0, 10, 0.5 ) );// 构造一个具有指定 value、minimum/maximum
																			// 边界和 stepSize 的
																			// SpinnerNumberModel
		panel.add( new JLabel( "Bounded JSpinner" ) );
		panel.add( spinner );

		// JSpinner with a List
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		spinner = new JSpinner( new SpinnerListModel( fonts )
		{
			@Override
			public Object getPreviousValue()
			{
				return super.getNextValue();
			}


			@Override
			public Object getNextValue()
			{
				return super.getPreviousValue();
			}
		} );
		panel.add( new JLabel( "List JSpinner" ) );
		panel.add( spinner );

		// 构造一个 SpinnerDateModel，其初始 value 为当前日期，calendarField 等于 Calendar.DAY_OF_MONTH，且没有 start/end 限制。
		spinner = new JSpinner( new SpinnerDateModel() );
		panel.add( new JLabel( "Date Spinner" ) );
		panel.add( spinner );

		// JSpinner with a DateEditor
		spinner = new JSpinner( new SpinnerDateModel() );
		String pattern = ((SimpleDateFormat) DateFormat.getInstance()).toPattern();
		spinner.setEditor( new JSpinner.DateEditor( spinner, pattern ) );
		panel.add( new JLabel( "Editor Spinner" ) );
		panel.add( spinner );

		// Timer JSpinner
		// 为具有默认语言环境的默认时区构造一个具有给定日期和时间设置的 GregorianCalendar(int year, int month, int dayOfMonth, int
		// hourOfDay, int minute)
		spinner = new JSpinner( new SpinnerDateModel( new GregorianCalendar( 2014, 12, 23, 12, 0, 0 ).getTime(), null, null,
				Calendar.HOUR ) );// (Date value, Comparable start, Comparable end, int calendarField)
		panel.add( new JLabel( "Timer Spinner" ) );
		panel.add( spinner );
		add( panel );
		setVisible( true );
		setSize( 450, 350 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new JSpinnerDemo();
	}

}
