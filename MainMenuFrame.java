import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuFrame extends JFrame {

	public MainMenuFrame() {
		initializeGUI();
	}
	
	private void initializeGUI() {
		//jB_* are JButton components
		JButton jB_ExitProg = new JButton("Quit Game");
		JButton jB_NewGame = new JButton("New Game");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("The Game of War - Main Menu");

		
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

		
	//initialize layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//create horizontal group
		GroupLayout.ParallelGroup hGroup = layout.createParallelGroup();
		hGroup.addComponent(jB_NewGame).addComponent(jB_ExitProg);
		
		//create vertical group
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addComponent(jB_NewGame).addComponent(jB_ExitProg);
		
		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
		
		pack();
	}
	
	//actions when main menu buttons are clicked
	private void jB_ExitProgActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	private void jB_NewGameActionPerformed(ActionEvent evt) {
		GameFrame gFrame = new GameFrame();
		this.dispose();
		gFrame.setVisible(true);
	}
}