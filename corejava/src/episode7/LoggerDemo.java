package episode7;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo
{

	public static void main(String[] args) throws SecurityException, IOException
	{
		Logger log = Logger.getLogger( "episode7.SystemInfo" );// 为指定子系统查找或创建一个 logger

		ConsoleHandler console = new ConsoleHandler();// 此 Handler 向 System.err 发布日志记录
		console.setLevel( Level.INFO );
		log.addHandler( console );

		FileHandler fileHandler = new FileHandler( "../logger.log" );// 简单的文件日志记录 Handler
		fileHandler.setLevel( Level.ALL );
		log.addHandler( fileHandler );

		log.setLevel( Level.INFO );
		log.info( "test aaaa" );
		// 设置Logger的级别:SEVERE（最高值）、WARNING、INFO、CONFIG、FINE、FINER、FINEST（最低值
		log.setLevel( Level.WARNING );
		log.info( "fine" );
	}
}
