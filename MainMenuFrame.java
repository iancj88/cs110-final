/**
*	This program reporoduces the card game, War.
*	It is meant to be automatically be played against the computer.
*	Directions are provided within the GUI.
*	Author: Ian C Johnson
*	Date: 12/5/13
*	Class: CS110
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
	This class provides the main menu interface with interactive buttons to a)play a game, b) exit, or c) read directions.
*/

public class MainMenuFrame extends JFrame {

	public MainMenuFrame() {
		initializeGUI();
	}
	
	private void initializeGUI() {
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("The Game of War - Main Menu");

		//jB_* are JButton components
		JButton jB_ExitProg = new JButton("Quit Game");
		JButton jB_NewGame = new JButton("New Game");
		JButton jB_Directions = new JButton("Directions");
		
		//set Tool Tip Popup text
		jB_ExitProg.setToolTipText("quit to desktop");
		jB_NewGame.setToolTipText("play a new game against the computer");
		
		//setup action listeners for each button
        jB_ExitProg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jB_ExitProgActionPerformed(evt);
            }
        });
		
		jB_NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_NewGameActionPerformed(evt);
			}
		} );
		jB_Directions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_DirectionsActionPerformed(evt);
			}
		} );

		
	//initialize layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//create horizontal group
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup
			.addComponent(jB_NewGame)
			.addComponent(jB_Directions)
			.addComponent(jB_ExitProg);
			
		
		//create vertical group
		GroupLayout.ParallelGroup vGroup = layout.createParallelGroup();
		vGroup
			.addComponent(jB_NewGame)
			.addComponent(jB_Directions)
			.addComponent(jB_ExitProg);
		
		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);

		pack();
	}
	
	/**
	* actions when main menu buttons are clicked
	*/
	
	private void jB_ExitProgActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	private void jB_NewGameActionPerformed(ActionEvent evt) {
		this.dispose();
		GameFrame gFrame = new GameFrame();
		gFrame.setVisible(true);
	}
	
	private void jB_DirectionsActionPerformed(ActionEvent evt) {
		String directionStr="The object of the game is to collect all the cards in the deck.\n In each round, both players place the card at the top of thier \nhand face up.\n\n The player with the higher value card (Ace-high -> two-low)\n collects both cards and adds them to his/her stack.\n\nIn event of a tie, a 'war' in instantiated whereby a single card \nis placed face down followed by another face up.\n\n The winner of this second faceoff collects all six cards in \nplay.";
		
		JOptionPane directionsPane = new JOptionPane();
		JOptionPane.showMessageDialog(null,directionStr,"Game Directions", JOptionPane.INFORMATION_MESSAGE);
	}
}