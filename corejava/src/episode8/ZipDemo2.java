package episode8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class ZipDemo2 extends JFrame
{
	JMenuBar bar;

	JMenu menu;

	JMenuItem open, exit;

	JFileChooser chooser;

	JComboBox fileCombo;

	JLabel area;

	String zipName;

	private ZipFile zip;


	// 603

	public ZipDemo2()
	{
		bar = new JMenuBar();
		menu = new JMenu( "File" );
		bar.add( menu );

		open = new JMenuItem( new AbstractAction( "Open" )
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				if (chooser == null)
					chooser = new JFileChooser();
				chooser.setCurrentDirectory( new File( "D:/" ) );
				ExtensionFileFilter filter = new ExtensionFileFilter();
				filter.addExtension( ".zip" );
				filter.addExtension( ".jar" );
				filter.setDescription( "ZIP archives" );
				chooser.setFileFilter( filter );
				int r = chooser.showOpenDialog( ZipDemo2.this );
				if (r == JFileChooser.APPROVE_OPTION)
				{
					zipName = chooser.getSelectedFile().getPath();
					scanZipFile();
				}
			}
		} );
		menu.add( open );
		exit = new JMenuItem( new AbstractAction( "Exit" )
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				System.exit( 0 );
			}
		} );
		menu.add( exit );

		area = new JLabel();
		fileCombo = new JComboBox();
		fileCombo.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				loadZipFile( (String) fileCombo.getSelectedItem() );
			}
		} );
		add( fileCombo, BorderLayout.SOUTH );
		add( new JScrollPane( area ), BorderLayout.CENTER );
		setJMenuBar( bar );
		setTitle( "Zip Demo" );
		setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setVisible( true );
	}


	public static void main(String[] args)
	{
		new ZipDemo2();
	}


	/*
	 * Scans the contents of the zip archive and populate the combo box
	 */
	public void scanZipFile()
	{
		fileCombo.removeAllItems();
		try
		{
			ZipInputStream zin = new ZipInputStream( new FileInputStream( zipName ) );
			ZipEntry entry;
			while ((entry = zin.getNextEntry()) != null)
			{
				fileCombo.addItem( entry.getName() );
				zin.closeEntry();
			}
			zin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	/*
	 * loads a file from the zip archive into the text area
	 */
	public void loadZipFile(String name)
	{
		try
		{
			zip = new ZipFile( zipName );
			ZipEntry ze = zip.getEntry( name );// 根据文件名取得压缩包中的对应条目
			InputStream input = zip.getInputStream( ze );
			byte[] b = new byte[4096000];
			input.read( b );
			area.setIcon( new ImageIcon( b ) );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
