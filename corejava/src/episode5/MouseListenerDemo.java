package episode5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerDemo extends JFrame
{

	public MouseListenerDemo()
	{
		setTitle( "MouseListener Demo" );
		setSize( 400, 300 );
		MousePanel panel = new MousePanel();
		add( panel );
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 300) / 2, (screenSize.height - 200) / 2 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );

	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new MouseListenerDemo();
	}

}

class MousePanel extends JPanel
{

	private Point2D first;

	private Point2D second;

	private Rectangle2D temp;

	private ArrayList<Rectangle2D> rects;


	public MousePanel()
	{
		rects = new ArrayList<Rectangle2D>();
		temp = new Rectangle2D.Double();
		setFocusable( true );
		addMouseListener( new MouseAdapter()
		{

			@Override
			public void mouseReleased(MouseEvent mouseevent)
			{
				second = mouseevent.getPoint();
				Rectangle2D rect = new Rectangle2D.Double();
				rect.setFrameFromDiagonal( first, second );
				rects.add( rect );
				repaint();
			}


			@Override
			public void mousePressed(MouseEvent mouseevent)
			{
				first = mouseevent.getPoint();
			}


			@Override
			public void mouseExited(MouseEvent mouseevent)
			{
				// TODO Auto-generated method stub

			}


			@Override
			public void mouseEntered(MouseEvent mouseevent)
			{
				// TODO Auto-generated method stub

			}


			@Override
			public void mouseClicked(MouseEvent mouseevent)
			{
				// TODO Auto-generated method stub

			}
		} );
	}


	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paint( g );
		Graphics2D g2 = (Graphics2D) g;
		for ( Rectangle2D rect : rects )
		{
			g2.draw( rect );
		}
		g2.draw( temp );
	}

}