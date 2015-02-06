package episode7;

import java.io.IOException;
import java.util.Properties;

public class SystemInfo
{

	/*
	 * 使用Properties类读取系统信息
	 */
	public static void main(String[] args) throws IOException
	{
		Properties sysprop = System.getProperties();
		// public void store(OutputStream out,String comments)
		sysprop.store( System.out, "System.properties" );
	}
}
