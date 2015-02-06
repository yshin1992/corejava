package episode6;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class MyFileView extends FileView
{
	/*
	 * 自定义文件视图
	 */
	FileFilter filter;

	Icon icon;


	public MyFileView()
	{
		filter = new IMGFileFilter();
		icon = new ImageIcon( "D:/code.gif" );
	}


	@Override
	public String getDescription(File arg0)
	{
		return arg0.getAbsolutePath() + "\\" + arg0.getName();
	}


	@Override
	public Icon getIcon(File arg0)
	{
		if (!arg0.isDirectory() && filter.accept( arg0 ))
			return icon;
		return null;
	}

	// @Override
	// public String getName(File arg0)
	// {
	// return arg0.getName();
	// }
	//
	//
	// @Override
	// public String getTypeDescription(File arg0)
	// {
	// return arg0.getName().toLowerCase().substring( arg0.getName().indexOf( '.' ) );
	// }
	//
	//
	// @Override
	// public Boolean isTraversable(File arg0)
	// {
	// // 这里设置的决定是用户点击一个目录是否打开它
	// return super.isTraversable( arg0 );
	// }

}
