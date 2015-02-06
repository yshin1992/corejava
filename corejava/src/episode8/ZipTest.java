package episode8;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * 
 * @author Qingxia Liu
 *
 */
public class ZipTest
{
	/**
	 * 为文件类型分类，以适当形式调用读取函数
	 * 调用格式，如ZipTest.display("F:\\DBpedia\\tst\\my.zip");
	 * @param filename 压缩文件的文件名
	 */
	public static void display(String filename)
	{
		File file = new File( filename );
		if (file.isDirectory())
		{
			File[] list = file.listFiles();
			for ( int i = 0; i < list.length; i++ )
			{
				ZipTest.display( list[i] );
			}
		}
		else
		{
			ZipTest.display( file );
		}
	}


	/**
	 * 依次读取压缩包中各文件内容
	 * @param file
	 */
	public static void display(File file)
	{
		String entryname = "abc";
		try
		{
			// System.out.println(file.toString());
			ZipFile zip = new ZipFile( file );// 由指定的File对象打开供阅读的ZIP文件
			Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();// 获取zip文件中的各条目（子文件）
			// ZipInputStream zis = new ZipInputStream(zip.getInputStream(zip.entries().nextElement()));
			while (entries.hasMoreElements())
			{// 依次访问各条目
				ZipEntry ze = entries.nextElement();
				BufferedReader br = new BufferedReader( new InputStreamReader( zip.getInputStream( ze ) ) );
				System.out.println( "\n" + ze.getName() + ":" );
				String line;
				while ((line = br.readLine()) != null)
				{
					System.out.println( line );
				}
				br.close();
			}

		}
		catch (ZipException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 读取压缩包file中，指定文件名entryname的文件的内容
	 * @param file
	 * @param entryname
	 */
	public static void display(File file, String entryname)
	{
		try
		{
			// System.out.println(file.toString());
			ZipFile zip = new ZipFile( file );
			// ZipInputStream zis = new ZipInputStream(zip.getInputStream(zip.entries().nextElement()));
			ZipEntry ze = zip.getEntry( entryname );// 根据文件名取得压缩包中的对应条目
			System.out.println( ze.getName() + ":" );
			BufferedReader br = new BufferedReader( new InputStreamReader( zip.getInputStream( ze ) ) );
			String line;
			while ((line = br.readLine()) != null)
			{
				System.out.println( line );
			}
			br.close();
		}
		catch (ZipException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String[] args)
	{
		String filename = "F:\\DBpedia\\tst\\my.zip";
		ZipTest.display( filename );
	}
}
