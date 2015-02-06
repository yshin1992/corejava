package episode8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class ZipDemo extends JFrame
{
	JMenuBar bar;

	JMenu menu;

	JMenuItem open, exit;

	JFileChooser chooser;

	JComboBox fileCombo;

	JTextArea area;

	String zipName;


	// 603

	public ZipDemo()
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
				chooser.setCurrentDirectory( new File( "." ) );
				ExtensionFileFilter filter = new ExtensionFileFilter();
				filter.addExtension( ".zip" );
				filter.addExtension( ".jar" );
				filter.setDescription( "ZIP archives" );
				chooser.setFileFilter( filter );
				int r = chooser.showOpenDialog( ZipDemo.this );
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

		area = new JTextArea();
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
		new ZipDemo();
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
			ZipInputStream zin = new ZipInputStream( new FileInputStream( zipName ) );
			ZipEntry entry;
			area.setText( "" );
			while ((entry = zin.getNextEntry()) != null)
			{
				if (entry.getName().equals( name ))
				{
					BufferedReader buffer = new BufferedReader( new InputStreamReader( zin ) );
					String line;
					while ((line = buffer.readLine()) != null)
					{
						area.append( line + "\n" );
					}
				}
				zin.closeEntry();
			}
			zin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class ExtensionFileFilter extends FileFilter
{
	private String desc = "";

	private ArrayList<String> exts = new ArrayList<String>();


	public void addExtension(String extension)
	{
		if (!extension.startsWith( "." ))
		{
			extension = "." + extension;
		}
		exts.add( extension.toLowerCase() );
	}


	@Override
	public boolean accept(File file)
	{
		if (file.isDirectory())
			return true;

		String name = file.getName().toLowerCase();
		for ( String e : exts )
		{
			if (name.endsWith( e ))
				return true;
		}
		return false;
	}


	public void setDescription(String desc)
	{
		this.desc = desc;
	}


	@Override
	public String getDescription()
	{
		return desc;
	}

}
