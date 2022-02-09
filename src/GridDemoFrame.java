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
		
		setSize(700,600+24+16);
		
		this.getContentPane().setLayout(new BorderLayout());
		thePanel = new GridDemoPanel(this);
		rulesLabel = new JTextArea("Colordoku rules: Click a box to change its color. There may only be one of each color in each row & column. \n Any box with a * can not change color");
		rulesLabel.setEditable(false);
		messageLabel = new JLabel("");
		Box southPanel = Box.createHorizontalBox();

		
		this.getContentPane().add(thePanel,BorderLayout.CENTER);
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.add(Box.createHorizontalStrut(10));
		southPanel.add(rulesLabel, BorderLayout.SOUTH);
		southPanel.add(Box.createGlue());
		southPanel.add(messageLabel, BorderLayout.SOUTH);
		southPanel.add(Box.createHorizontalStrut(10));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
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
