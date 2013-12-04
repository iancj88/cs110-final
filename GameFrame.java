import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
	
	
	public GameFrame() {
		initializeGUI();
	}
	
	private void initializeGUI() {
	
		//setup game buttons
		JButton jB_EndGame = new JButton("end game");
		JButton jB_FlipNext = new JButton("next card");
		JButton jB_showScore = new JButton("show score");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("The Game of War");
		
		//setup action listeners for buttons
		jB_EndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_EndGameActionPerformed(evt);
			}
		} );
		jB_FlipNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_FlipNextActionPerformed(evt);
			}
		} );
		jB_showScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_showScoreActionPerformed(evt);
			}
		} );
		
	//initialize layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//create vertical group
		GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
		vGroup.addComponent(jB_FlipNext).addComponent(jB_EndGame);
		
		//create horizontal group
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addComponent(jB_FlipNext).addComponent(jB_EndGame);
		
		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
		
		pack();
	}
	
	//Button Action methods
	private void jB_EndGameActionPerformed(ActionEvent evt) {
		mainMenu.setVisible(true);
		this.dispose();
	}
	private void jB_FlipNextActionPerformed(ActionEvent evt) {

	}
	private void jB_showScoreActionPerformed(ActionEvent evt) {

	}	
	
	public void updateScore(int computerScore) {
		int yourScore = 52 - computerScore;
		setTitle("You: " + yourScore + " Computer: " + computerScore);
	}
	
	
}