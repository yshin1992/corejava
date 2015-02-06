package episode7;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RobotDemo
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame( "Demo" );
		frame.setVisible( true );
		frame.setLocation( 400, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// 获取Robot类的步骤
		// 第一步：获取GraphicsDevice
		GraphicsEnvironment enviroment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = enviroment.getDefaultScreenDevice();

		// 第二步：构造一个Robot对象
		try
		{
			Robot robot = new Robot( screen );
			run( robot );
		}
		catch (AWTException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void run(Robot robot)
	{
		// simulate a space bar press
		robot.keyPress( ' ' );
		robot.keyRelease( ' ' );
		// simulate a tab key followed by a space
		robot.delay( 2000 );
		robot.keyPress( KeyEvent.VK_TAB );
		robot.keyRelease( KeyEvent.VK_TAB );
		robot.keyPress( ' ' );
		robot.keyRelease( ' ' );
		// simulate a mouse click over the right mouse button
		robot.delay( 2000 );
		robot.mouseMove( 200, 50 );
		robot.mousePress( InputEvent.BUTTON1_MASK );
		robot.mouseRelease( InputEvent.BUTTON1_MASK );

		// capture the screen and show the resulting image
		robot.delay( 2000 );
		// 抓取图像
		BufferedImage image = robot.createScreenCapture( new Rectangle( 0, 0, 400, 300 ) );// 创建包含从屏幕中读取的像素的图像
		new ImageFrame( image );
	}

}

class ImageFrame extends JFrame
{
	public ImageFrame(Image image)
	{
		setTitle( "Capture" );
		setSize( 400, 300 );
		JLabel label = new JLabel( new ImageIcon( image ) );
		add( label );
		setVisible( true );
	}
}
