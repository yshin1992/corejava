package episode7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo
{

	/*
	 * 使用Properties读取/写入信息
	 */
	public static void main(String[] args) throws IOException
	{
		Properties settings = new Properties();
		settings.put( "font", "Courier" );
		settings.put( "size", "10" );
		settings.put( "message", "Hello world!" );
		FileOutputStream out = new FileOutputStream( "D:/myprop.properties" );
		// public void store(OutputStream out,String comments)throws IOException
		settings.store( out, "D:/myprop.properties" );// 以适合使用 load(Reader) 方法的格式，将此 Properties
														// 表中的属性列表（键和元素对）写入输出字符。
		FileInputStream in = new FileInputStream( "D:/myprop.properties" );
		settings.load( in );
		String msg = settings.getProperty( "message" );
		System.out.println( msg );
	}
}
