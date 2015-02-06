package episode6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldDemo
{

	public static void main(String[] args)
	{
		Thread t1 = new Thread( new TextFrame() );// 334
		t1.start();
	}
}

class TextFrame extends JFrame implements Runnable
{
	private JTextField hourField, minuteField;

	private ClockPanel clock;

	private int hours = 12, minutes = 0;

	private class ClockFieldListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent arg0)
		{
			// TODO Auto-generated method stub

		}


		@Override
		public void insertUpdate(DocumentEvent arg0)
		{
			setClock();
		}


		@Override
		public void removeUpdate(DocumentEvent arg0)
		{
			setClock();
		}

	}


	public void setClock()
	{
		try
		{
			int hours = Integer.parseInt( hourField.getText().trim().equals( "" ) ? "00" : hourField.getText().trim() );
			int minutes = Integer.parseInt( minuteField.getText().trim().equals( "" ) ? "00" : minuteField.getText().trim() );
			clock.setTime( hours, minutes );
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
	}


	public TextFrame()
	{
		setTitle( "TextFieldDemo" );

		DocumentListener listener = new ClockFieldListener();

		JPanel panel = new JPanel();
		panel.add( new JLabel( "Hour:" ) );
		hourField = new JTextField( "12", 3 );
		panel.add( hourField );
		hourField.getDocument().addDocumentListener( listener );

		panel.add( new JLabel( "Minute:" ) );
		minuteField = new JTextField( "00", 3 );
		panel.add( minuteField );
		minuteField.getDocument().addDocumentListener( listener );

		add( panel, BorderLayout.SOUTH );

		clock = new ClockPanel();
		add( clock, BorderLayout.CENTER );
		pack();
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

	}


	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep( 1000 );
				minuteField.setText( "" + minutes++ );
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

class ClockPanel extends JPanel
{
	private double minutes = 0;

	private int RADIUS = 100;

	private double MINUTE_HAND_LENGTH = 0.8 * RADIUS;

	private double HOUR_HAND_LENGTH = 0.6 * RADIUS;


	public ClockPanel()
	{
		setPreferredSize( new Dimension( 2 * RADIUS + 1, 2 * RADIUS + 1 ) );
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paintComponent( g );
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double( 0, 0, 2 * RADIUS, 2 * RADIUS );
		g2.draw( circle );

		double hourAngle = Math.toRadians( 90 - 360 * minutes / (12 * 60) );
		drawHand( g2, hourAngle, HOUR_HAND_LENGTH );

		double minuteAngel = Math.toRadians( 90 - 360 * minutes / 60 );
		drawHand( g2, minuteAngel, MINUTE_HAND_LENGTH );
	}


	public void drawHand(Graphics2D g2, double angle, double length)
	{
		Point2D end = new Point2D.Double( RADIUS + length * Math.cos( angle ), RADIUS - length * Math.sin( angle ) );
		Point2D center = new Point2D.Double( RADIUS, RADIUS );
		g2.draw( new Line2D.Double( center, end ) );
	}


	public void setTime(int h, int m)
	{
		minutes = h * 60 + m;
		repaint();
	}
}
