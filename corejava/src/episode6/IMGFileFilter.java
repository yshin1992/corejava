package episode6;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class IMGFileFilter extends FileFilter
{

	/*
	 * 自定义图像文件选择器
	 */
	private static String[] allowFileType = new String[] { ".gif", ".jpg", ".jpeg", ".png", ".bmp", ".swf", ".psd" };


	@Override
	public boolean accept(File f)
	{
		if (f.isDirectory())
			return true;
		String fileName = f.getName().toLowerCase();
		for ( String type : allowFileType )
		{
			if (fileName.endsWith( type ))
				return true;
		}
		return false;
	}


	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return "image";
	}

}
