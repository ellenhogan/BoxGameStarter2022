import javax.swing.*;
import java.awt.*;

public class GridDemoRunner
{

	public static void main(String[] args)
	{
		Icon firstIcon = new ImageIcon("levelTwo.png");
		Icon secondIcon = new ImageIcon("levelOne.png");

//		JPanel requestPanel = new JPanel();
//		JCheckBox checkBox = new JCheckBox(firstIcon);
//		requestPanel.setLayout(new GridLayout(1,1));
//		requestPanel.add(checkBox);

//		JOptionPane.showMessageDialog(null, requestPanel);
//		//if (result == JOptionPane.OK_OPTION)
//			System.out.println("Is the checkbox selected? "+checkBox.isSelected());
		JFrame frame = new JFrame();
//		Icon firstIcon = new ImageIcon("");
//		Icon secondIcon = new ImageIcon("");
		Object[] iconArray = { firstIcon, secondIcon };

		JOptionPane.showOptionDialog(frame, "Ready to play? Select a Level", "Colordoku Menu",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, iconArray, iconArray[1]);

		// by default, we're using the StartHereFrame so you can get used to the Cell class;
		// switch the comme

		// hello
		// StartHereFrame practiceApp = new StartHereFrame();
		GridDemoFrame app = new GridDemoFrame();

	}

}
