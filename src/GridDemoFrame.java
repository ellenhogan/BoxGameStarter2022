import java.awt.BorderLayout;

import javax.swing.*;

public class GridDemoFrame extends JFrame
{
	GridDemoPanel thePanel;
	JTextArea rulesLabel;
	JLabel messageLabel;
	public GridDemoFrame()
	{
		super("Colordoku");
		Icon firstIcon = new ImageIcon("levelTwo.png");
		Icon secondIcon = new ImageIcon("levelOne.png");
		JFrame frame = new JFrame();
//		Icon firstIcon = new ImageIcon("");
//		Icon secondIcon = new ImageIcon("");
		Object[] iconArray = { firstIcon, secondIcon };
		int result = JOptionPane.showOptionDialog(frame, "Ready to play? Select a Level", "Colordoku Menu",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, iconArray, iconArray[1]);
		System.out.println(result);
		if(result == 1) {
			setSize(700, 600 + 24 + 16);

			this.getContentPane().setLayout(new BorderLayout());
			thePanel = new level1(this);
			rulesLabel = new JTextArea("Colordoku rules: Click a box to change its color. There may only be one of each color in each row & column. \n Any box with a * can not change color");
			rulesLabel.setEditable(false);
			messageLabel = new JLabel("");
			Box southPanel = Box.createHorizontalBox();


			this.getContentPane().add(thePanel, BorderLayout.CENTER);
			this.getContentPane().add(southPanel, BorderLayout.SOUTH);
			southPanel.add(Box.createHorizontalStrut(10));
			southPanel.add(rulesLabel, BorderLayout.SOUTH);
			southPanel.add(Box.createGlue());
			southPanel.add(messageLabel, BorderLayout.SOUTH);
			southPanel.add(Box.createHorizontalStrut(10));

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		else if(result == 0) {
		setSize(700, 600 + 24 + 16);

		this.getContentPane().setLayout(new BorderLayout());
		thePanel = new level2(this);
		rulesLabel = new JTextArea("Colordoku rules: Click a box to change its color. There may only be one of each color in each row & column. \n Any box with a * can not change color");
		rulesLabel.setEditable(false);
		messageLabel = new JLabel("");
		Box southPanel = Box.createHorizontalBox();


		this.getContentPane().add(thePanel, BorderLayout.CENTER);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.add(Box.createHorizontalStrut(10));
		southPanel.add(rulesLabel, BorderLayout.SOUTH);
		southPanel.add(Box.createGlue());
		southPanel.add(messageLabel, BorderLayout.SOUTH);
		southPanel.add(Box.createHorizontalStrut(10));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//	thePanel.initiateAnimationLoop(); // uncomment this line if your program uses animation.
	}
	
	public void updateMessage(String message)
	{
		messageLabel.setText(message);
		messageLabel.repaint();
	}
	
	/*public void updateScore(int score)
	{
		scoreLabel.setText("Score: "+score);
		scoreLabel.repaint();
	}*/
}
