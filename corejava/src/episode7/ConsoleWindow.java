package episode7;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsoleWindow
{
	/*
	 * 自定义控制台输出信息
	 */
	public static void init()
	{
		JFrame frame = new JFrame();
		frame.setTitle( "ConsoleWindow" );
		final JTextArea output = new JTextArea();
		output.setEditable( false );
		frame.add( new JScrollPane( output ) );
		frame.setSize( 600, 300 );
		frame.setFocusableWindowState( false );// 设置如果此窗口满足 isFocusableWindow 中列出的其他要求，其是否可以成为焦点窗口
		frame.setVisible( true );
		PrintStream consoleStream = new PrintStream( new OutputStream()
		{

			@Override
			public void write(int i) throws IOException
			{
			}


			@Override
			public void write(byte[] b, int off, int len)
			{
				output.append( new String( b, off, len ) );
			}
		} );

		System.setOut( consoleStream );
		System.setErr( consoleStream );
	}
}
