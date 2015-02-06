package episode7;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

public class PreferencesDemo extends JFrame
{
	JMenuBar menuBar;

	JMenu menu;

	JMenuItem exportItem, importItem, exitItem;


	public PreferencesDemo()
	{
		// 此类允许应用程序存储和获取用户和系统首选项以及配置数据。此数据持久存储在依赖于实现的内部存储中
		Preferences root = Preferences.userRoot();// 返回调用用户的根首选项节点
		final Preferences node = root.userNodeForPackage( this.getClass() );// 从调用用户首选项树（根据约定，它与指定类的包相关联）返回首选项节点。
		int left = node.getInt( "left", 0 );
		int top = node.getInt( "top", 0 );
		int width = node.getInt( "width", 300 );
		int height = node.getInt( "width", 400 );
		setBounds( left, top, width, height );
		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory( new File( "." ) );

		chooser.setFileFilter( new FileFilter()
		{

			@Override
			public String getDescription()
			{
				return "XML files";
			}


			// 在视图中显示的文件
			@Override
			public boolean accept(File f)
			{
				return f.getName().toLowerCase().endsWith( ".xml" ) || f.isDirectory();
			}
		} );

		menuBar = new JMenuBar();
		setJMenuBar( menuBar );

		menu = new JMenu( "File" );
		menu.setMnemonic( 'F' );
		menuBar.add( menu );

		exportItem = new JMenuItem( new AbstractAction( "Export" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (chooser.showSaveDialog( PreferencesDemo.this ) == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						OutputStream out = new FileOutputStream( chooser.getSelectedFile() );
						node.exportSubtree( out );// 发出表示此节点及其所有子节点中包含的全部首选项的 XML 文档
						out.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		} );
		// 设置一个加速键
		exportItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_E, InputEvent.CTRL_MASK ) );

		menu.add( exportItem );

		importItem = new JMenuItem( new AbstractAction( "Import" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (chooser.showOpenDialog( PreferencesDemo.this ) == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						InputStream in = new FileInputStream( chooser.getSelectedFile() );
						node.importPreferences( in );
						in.close();
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		} );
		importItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_I, InputEvent.CTRL_MASK ) );
		menu.add( importItem );

		exitItem = new JMenuItem( new AbstractAction( "Exit" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				node.putInt( "left", getX() );
				node.putInt( "top", getY() );
				node.putInt( "width", getWidth() );
				node.putInt( "height", getHeight() );
				System.exit( 0 );
			}
		} );
		exitItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_F4, InputEvent.ALT_MASK ) );
		menu.add( exitItem );
		setTitle( "Preferences" );
		// setSize( 400, 300 );
		setVisible( true );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public static void main(String[] args)
	{
		new PreferencesDemo();
	}

}
