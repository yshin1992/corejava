package episode1;

import javax.swing.JOptionPane;

public class JOptionPanelDemo
{

	public static void main(String[] args)
	{
		String str1 = JOptionPane.showInputDialog( null, "Please input  a number", "input box", JOptionPane.INFORMATION_MESSAGE );
		int confirm = JOptionPane.showConfirmDialog( null, "Are you sure your input " + str1, "confirm box", JOptionPane.OK_CANCEL_OPTION );
		if (confirm == JOptionPane.OK_OPTION)
		{
			JOptionPane.showMessageDialog( null, "you have input " + str1, "message box", JOptionPane.OK_OPTION );
		}
	}
}
