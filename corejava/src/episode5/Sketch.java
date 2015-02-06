package episode5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sketch extends JFrame
{
	public Sketch()
	{
		setTitle( "keyListener Demo" );
		setSize( 400, 300 );
		SketchPanel panel = new SketchPanel();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new Sketch();
	}

}

class SketchPanel extends JPanel
{
	private Point2D last;

	private static final int SMALL_INCREAMENT = 1;

	private static final int LARGE_INCREAMENT = 5;

	private ArrayList<Line2D> lines;


	public SketchPanel()
	{
		last = new Point2D.Double( 100, 100 );
		lines = new ArrayList<Line2D>();
		setFocusable( true );
		addKeyListener( new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent keyevent)
			{
				int d;
				if (keyevent.isShiftDown())
					d = LARGE_INCREAMENT;
				else
					d = SMALL_INCREAMENT;
				if (keyevent.getKeyCode() == KeyEvent.VK_D)
					add( d, 0 );
				else
					if (keyevent.getKeyCode() == KeyEvent.VK_A)
						add( -d, 0 );
					else
						if (keyevent.getKeyCode() == KeyEvent.VK_W)
							add( 0, -d );
						else
							if (keyevent.getKeyCode() == KeyEvent.VK_S)
								add( 0, d );
			}


			@Override
			public void keyReleased(KeyEvent keyevent)
			{
				// TODO Auto-generated method stub

			}


			@Override
			public void keyPressed(KeyEvent keyevent)
			{
				int d;
				if (keyevent.isShiftDown())
					d = LARGE_INCREAMENT;
				else
					d = SMALL_INCREAMENT;
				if (keyevent.getKeyCode() == KeyEvent.VK_RIGHT)
					add( d, 0 );
				else
					if (keyevent.getKeyCode() == KeyEvent.VK_LEFT)
						add( -d, 0 );
					else
						if (keyevent.getKeyCode() == KeyEvent.VK_UP)
							add( 0, -d );
						else
							if (keyevent.getKeyCode() == KeyEvent.VK_DOWN)
								add( 0, d );
			}
		} );
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		Graphics2D g2 = (Graphics2D) g;
		for ( Line2D l : lines )
		{
			g2.draw( l );
		}
	}


	public void add(int dx, int dy)
	{
		Point2D end = new Point2D.Double( last.getX() + dx, last.getY() + dy );
		Line2D line = new Line2D.Double( last, end );
		lines.add( line );
		repaint();
		last = end;
	}

}
