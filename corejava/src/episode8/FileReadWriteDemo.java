package episode8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileReadWriteDemo
{

	public static void main(String[] args)
	{
		InputStream fis = null;
		OutputStream fos = null;
		try
		{
			fis = new BufferedInputStream( new FileInputStream( "E:/000 (Large).jpg" ) );
			fos = new BufferedOutputStream( new FileOutputStream( "D:/000.jpg" ) );
			byte[] buf = new byte[102400];
			int i;
			while ((i = fis.read( buf )) != -1)
			{
				fos.write( buf, 0, i );
				System.out.println( "loop" );
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fos.close();
				fis.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
