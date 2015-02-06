package episode5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawImgaeDemo1 extends JFrame
{

	private ImagePanel imgPanel;

	private static final int WIDTH = 500;

	private static final int HEIGHT = 300;


	public DrawImgaeDemo1() throws IOException
	{
		this.setTitle( "绘制图形的JFrame" );
		this.setSize( WIDTH, HEIGHT );
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation( (screenSize.width - WIDTH) / 2, (screenSize.height - HEIGHT) / 2 );

		imgPanel = new ImagePanel();
		add( imgPanel );

		// Image img = kit.getImage( "img/win.png" );
		Image img = ImageIO.read( new File( "img/win.png" ) );
		setIconImage( img );// 此方法失效
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args) throws IOException
	{
		DrawImgaeDemo1 draw = new DrawImgaeDemo1();
		// DisposeFrame dframe = new DisposeFrame( draw );
		// Timer timer = new Timer( 1000, dframe );
		// timer.start();
	}

}

class ImagePanel extends JPanel
{

	public ImagePanel()
	{
		setBackground( new Color( 255, 255, 205 ) );
	}


	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent( g );
		g.setColor( Color.blue );
		g.setFont( new Font( "楷体", Font.BOLD, 14 ) );
		g.drawString( "Hello,this is a simple String!", 30, 30 );
		// Image img = Toolkit.getDefaultToolkit().getImage( "img/win.png" );
		// g.drawImage( img, 60, 60, 30, 30, null );
		g.fillRect( 60, 60, 5, 30 );
		g.drawRect( 64, 65, 21, 20 );
		g.fillOval( 68, 68, 14, 14 );
		g.fillRect( 74, 58, 2, 15 );
		g.fillRect( 85, 60, 5, 30 );
		g.drawString( "Graphics Tank", 30, 110 );

		// Java2D
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rect2D = new Rectangle2D.Double( 150, 60, 5, 30 );
		g2.fill( rect2D );// 左车轮
		g2.draw( new Rectangle2D.Double( 154, 65, 21, 20 ) );// 坦克主体
		g2.fill( new Ellipse2D.Double( 158, 68, 14, 14 ) );// 坦克转向台
		g2.fill( new Rectangle2D.Double( 175, 60, 5, 30 ) );// 右车轮
		g2.fill( new Rectangle2D.Double( 164, 58, 2, 15 ) );// 炮筒
		g.drawString( "Graphics2D Tank", 150, 110 );

		double left = 50;
		double top = 150;
		double width = 150;
		double height = 80;

		Rectangle2D rect = new Rectangle2D.Double( left, top, width, height );
		g2.draw( rect );
		g2.draw( new Line2D.Double( left, top, left + width, top + height ) );
		g2.draw( new Ellipse2D.Double( left, top, width, height ) );

		double centerX = rect.getCenterX();// 返回闭合矩形的中心
		double centerY = rect.getCenterY();
		Ellipse2D ellipse = new Ellipse2D.Double();
		double radius = 85;
		ellipse.setFrameFromCenter( centerX, centerY, centerX + radius, centerY + radius );
		g2.draw( ellipse );

		Rectangle2D rect2d = new Rectangle2D.Double();
		rect2d.setFrameFromDiagonal( 400, 200, 300, 100 );
		g2.draw( rect2d );
		Image img;
		try
		{
			img = ImageIO.read( new File( "img/win.png" ) );
			System.out.println( img.getWidth( null ) );
			System.out.println( img.getHeight( null ) );
			g2.drawImage( img, 305, 105, 50, 50, null );
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class DisposeFrame implements ActionListener
{

	private DrawImgaeDemo1 draw;


	public DisposeFrame(DrawImgaeDemo1 draw)
	{
		this.draw = draw;
	}


	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.draw.dispose();
	}

}
