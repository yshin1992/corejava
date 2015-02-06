package episode6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JMenuDemo extends JFrame
{
	JMenuBar bar;// 菜单栏

	JMenu editMenu, fileMenu, newItem, options, appearence;// 菜单

	JMenuItem copy, cut, paste, open, cFile, javaFile, cplusFile, exitItem, aboutItem;// 菜单项

	JCheckBoxMenuItem check1;// 复选框按钮菜单项

	JRadioButtonMenuItem radio1, radio2;// 单选框按钮菜单项

	ButtonGroup group;

	JMenuItem[] lookfeel;// 外观

	JPopupMenu popup;// 弹出菜单

	JPanel panel;

	JButton btn, btn2, btn3, btn4, toolbtn1, toolbtn2;

	JToolBar tools;// 工具栏

	JDialog dialog, colorDialog, dialog2;// 对话框

	JFileChooser fileChooser, fileChooser2;// 文件选择框

	JLabel preview;// 设置预览标签

	JColorChooser colorChooser, colorChooser2;// 颜色选择对话框

	Color color;// 面板当前的颜色

	JTextArea area;// 文本域

	JScrollPane scroll;// 滚动面板


	public JMenuDemo() throws IOException
	{
		panel = new JPanel();
		btn = new JButton( "文件选择对话框" );
		btn2 = new JButton( "颜色选择对话框" );
		color = panel.getBackground();
		btn.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (fileChooser == null)
				{
					// 第一步：建立一个文件对话框
					fileChooser = new JFileChooser();
				}
				// 第二步：设置当前路径
				fileChooser.setCurrentDirectory( new File( "D:/" ) );
				// 第三步：可设置一个希望用户选择的默认的文件名 (可省略此步)
				fileChooser.setSelectedFile( new File( "D:/crane.sql" ) );
				// 第四步：可以设置用户选择的文件为多选
				fileChooser.setMultiSelectionEnabled( true );
				// 第五步：可以指定用户选择指定类型的文件
				fileChooser.setFileFilter( new IMGFileFilter() );
				// 第六步：可以指定用户选择的可以是目录 JFileChooser.FILES_AND_DIRECTORIES
				fileChooser.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );

				// fileChooser.addChoosableFileFilter( new FileFilter() );//为选择器安装多个过滤器

				// 设置文件视图
				fileChooser.setFileView( new MyFileView() );

				// 设置预览视图
				preview = new ImagePreviewer( fileChooser );
				fileChooser.setAccessory( preview );// 设置一个附件组件

				// 放弃All files过滤器
				fileChooser.setAcceptAllFileFilterUsed( false );

				// 第七步：调用showOpenDialog()或showSaveDialog()显示对话框
				int result = fileChooser.showOpenDialog( JMenuDemo.this );
				if (result == JFileChooser.APPROVE_OPTION)
				{
					// 第八步：使用getSelectedFile()或者getSelectedFiles()获取一个或多个文件
					File[] files = fileChooser.getSelectedFiles();
					for ( File f : files )
					{
						System.out.println( f.getAbsolutePath() + "\\" + f.getName() );
					}
				}
			}
		} );

		btn2.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				if (colorChooser == null)
				{
					colorChooser = new JColorChooser();
				}
				/*
				 * 创建一个无模式的对话框
				 */
				// createDialog(Component c, String title, boolean modal, JColorChooser chooserPane,
				// ActionListener okListener, ActionListener cancelListener)
				// 创建并返回包含指定 ColorChooser 窗格及 "OK"、"Cancel" 和 "Reset" 按钮的新对话框。
				colorDialog = JColorChooser.createDialog( JMenuDemo.this, "Set Background Color", false, colorChooser, new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent actionevent)
					{
						color = colorChooser.getColor();
						panel.setBackground( color );
					}
				}, new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent actionevent)
					{
						panel.setBackground( color );
					}
				} );
				colorDialog.setVisible( true );
				// 为选择器的选择模型添加改变监听器
				colorChooser.getSelectionModel().addChangeListener( new ChangeListener()
				{

					@Override
					public void stateChanged(ChangeEvent changeevent)
					{
						panel.setBackground( colorChooser.getColor() );
					}
				} );
			}
		} );

		/*
		 * 创建模式选择对话框
		 */
		btn3 = new JButton( "(模式)颜色选择对话框" );
		btn3.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				Color c = JColorChooser.showDialog( null, "(模式)颜色选择对话框", color );
				color = c;
				panel.setBackground( c );
			}
		} );

		/*
		 * 创建无模式对话框，同第一种方式
		 */
		btn4 = new JButton( "(无模式)颜色选择对话框" );
		btn4.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				dialog2 = new JDialog();
				if (colorChooser2 == null)
				{
					colorChooser2 = new JColorChooser();
				}
				dialog2.add( colorChooser2 );
				dialog2.pack();
				dialog2.setVisible( true );
			}
		} );
		panel.add( btn );
		panel.add( btn2 );
		panel.add( btn3 );
		panel.add( btn4 );

		area = new JTextArea( 10, 35 );
		scroll = new JScrollPane( area );
		panel.add( scroll );
		add( panel );

		bar = new JMenuBar();
		fileMenu = new JMenu( "File" );// 创建菜单
		fileMenu.setMnemonic( 'F' );
		bar.add( fileMenu );// 将菜单添加到菜单栏中
		open = new JMenuItem( new AbstractAction( "Open" )
		{

			@Override
			public void actionPerformed(ActionEvent actionevent)
			{
				area.setText( "" );
				if (fileChooser2 == null)
				{
					// 第一步：建立一个文件对话框
					fileChooser2 = new JFileChooser();
				}
				// 第二步：设置当前路径
				fileChooser2.setCurrentDirectory( new File( "D:/" ) );
				// 第三步：可设置一个希望用户选择的默认的文件名 (可省略此步)
				fileChooser2.setSelectedFile( new File( "D:/crane.sql" ) );
				// 第六步：可以指定用户选择的可以是目录 JFileChooser.FILES_AND_DIRECTORIES
				fileChooser2.setFileSelectionMode( JFileChooser.FILES_ONLY );

				// 第七步：调用showOpenDialog()或showSaveDialog()显示对话框
				int result = fileChooser2.showOpenDialog( JMenuDemo.this );
				if (result == JFileChooser.APPROVE_OPTION)
				{
					// 第八步：使用getSelectedFile()或者getSelectedFiles()获取一个或多个文件
					File file = fileChooser2.getSelectedFile();
					try
					{
						String temp = "";
						BufferedReader br = new BufferedReader( new FileReader( file ) );
						while ((temp = br.readLine()) != null)
						{
							area.append( temp + "\n" );
						}
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} );
		fileMenu.add( open );
		newItem = new JMenu( "New" );
		fileMenu.add( newItem );

		cFile = new JMenuItem( "C" );
		javaFile = new JMenuItem( "Java" );
		cplusFile = new JMenuItem( "C++" );
		newItem.add( cFile );
		newItem.add( javaFile );
		newItem.add( cplusFile );

		aboutItem = new JMenuItem( new AbstractAction( "关于" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (dialog == null)
				{
					dialog = new AboutDialog( JMenuDemo.this );
					System.out.println( "new dialog" );
				}
				dialog.setVisible( true );
			}
		} );
		fileMenu.add( aboutItem );

		Action exit = new AbstractAction( "Exit" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit( 0 );
			}
		};
		exitItem = new JMenuItem( exit );
		fileMenu.add( exitItem );// 添加菜单项及相关动作

		editMenu = new JMenu( "Edit" );
		editMenu.setMnemonic( 'E' );
		bar.add( editMenu );
		copy = new JMenuItem( "Copy", new ImageIcon( ImageIO.read( new File( "img/win.png" ) ) ) );
		editMenu.add( copy );
		cut = new JMenuItem( "Cut" );
		editMenu.add( cut );
		editMenu.addSeparator();// 添加水平线
		paste = new JMenuItem( "Paste" );
		paste.setEnabled( false );// 禁用菜单项
		editMenu.add( paste );
		// 快捷键
		copy.setMnemonic( 'c' );// 设置按钮的助记符
		cut.setMnemonic( 't' );
		paste.setMnemonic( 'p' );
		// 加速键
		copy.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_C, InputEvent.CTRL_MASK ) );
		cut.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_X, InputEvent.CTRL_MASK ) );
		paste.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_V, InputEvent.CTRL_MASK ) );
		exitItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_F1, InputEvent.ALT_MASK ) );
		// editMenu.insertSeparator( 3 );// 注意水平线也占一个item位置
		editMenu.addSeparator();
		options = new JMenu( "Options" );
		check1 = new JCheckBoxMenuItem( "Read-Only" );
		options.add( check1 );
		options.addSeparator();
		group = new ButtonGroup();
		radio1 = new JRadioButtonMenuItem( "Insert" );
		radio2 = new JRadioButtonMenuItem( "Delete" );
		group.add( radio1 );
		group.add( radio2 );
		options.add( radio1 );
		options.add( radio2 );
		editMenu.add( options );

		// 外观
		appearence = new JMenu( "外观" );
		initAppearItem();
		bar.add( appearence );

		setJMenuBar( bar );// 将菜单栏添加到框架中

		// 工具栏
		tools = new JToolBar( "工具栏" );
		toolbtn1 = new JButton( "保存" );
		toolbtn1.setToolTipText( "Save" );// 设置提示文字
		tools.add( toolbtn1 );
		tools.addSeparator();
		toolbtn2 = new JButton( "另存为" );// 设置提示文字
		tools.add( toolbtn2 );
		toolbtn2.setToolTipText( "Save As" );
		tools.add( new ColorAction( "Red", Color.red ) );
		tools.add( new ColorAction( "Blue", Color.blue ) );

		add( tools, BorderLayout.NORTH );
		// 弹出菜单
		popup = new JPopupMenu();// 新建弹出菜单
		// popup.add( copy );
		// popup.add( cut );
		// popup.add( paste );
		panel.setComponentPopupMenu( popup );// 给panel设置弹出菜单
		btn.setInheritsPopupMenu( true );// 继承父组件的弹出菜单

		setVisible( true );
		setSize( 450, 350 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}


	public void initAppearItem()
	{
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		lookfeel = new JMenuItem[looks.length];
		for ( int i = 0; i < looks.length; i++ )
		{
			final String look = looks[i].getClassName();
			lookfeel[i] = new JMenuItem( new AbstractAction( looks[i].getName() )
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						UIManager.setLookAndFeel( look );
						SwingUtilities.updateComponentTreeUI( JMenuDemo.this );
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			} );
			appearence.add( lookfeel[i] );
		}
	}


	public static void main(String[] args) throws IOException
	{
		new JMenuDemo();
	}

	class ColorAction extends AbstractAction
	{

		public ColorAction(String name, Color c)
		{
			putValue( Action.NAME, name );
			putValue( "Color", c );
		}


		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Color c = (Color) getValue( "Color" );
			panel.setBackground( c );
		}

	}
}

class AboutDialog extends JDialog
{
	public AboutDialog(JFrame owner)
	{
		super( owner, "About Dialog", true );
		setLayout( new BorderLayout() );
		add( new JLabel( "<html><h1>Author:Yanshuai</h1><h2>time:2015/2/4<br/>version:1.0</h2></html>" ), BorderLayout.CENTER );
		JPanel panel = new JPanel();
		Action action = new AbstractAction( "OK" )
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				AboutDialog.this.dispose();
			}
		};
		panel.add( new JButton( action ) );
		add( panel, BorderLayout.SOUTH );
		setSize( 350, 250 );
	}
}

class ImagePreviewer extends JLabel
{
	public ImagePreviewer(JFileChooser chooser)
	{
		setPreferredSize( new Dimension( 100, 100 ) );
		setBorder( BorderFactory.createEtchedBorder() );
		chooser.addPropertyChangeListener( new PropertyChangeListener()
		{

			@Override
			public void propertyChange(PropertyChangeEvent event)
			{
				if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					// 用户选择一个新的文件
					File f = (File) event.getNewValue();
					if (f == null)
					{
						setIcon( null );
						return;
					}
					ImageIcon icon = new ImageIcon( f.getPath() );

					// if icon is too large to fit,scale it
					if (icon.getIconWidth() > getWidth())
					{
						// 创建此图像的缩放版本,如果 width 或 height 为负数，则替换该值以维持初始图像尺寸的高宽比。如果 width 和 height 都为负，则使用初始图像尺寸
						// 使用默认的图像缩放算法
						icon = new ImageIcon( icon.getImage().getScaledInstance( getWidth(), -1, Image.SCALE_DEFAULT ) );
					}
					setIcon( icon );
				}
			}
		} );
	}
}
