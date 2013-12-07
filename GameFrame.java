/**GameFrame Class -
*	This provides the primary interface while playing the game.
*	This class initializes card dealings, and determines each round's, as well the game's winner.
*
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends JFrame {

	//class variables
	GroupLayout layout = new GroupLayout(getContentPane());
	Player p1 = new Player();
	Player p2 = new Player();
	Deck undealtDeck = new Deck();
	int numRounds = 0;
	ImageIcon defaultIcon = new ImageIcon("cardPics\\blank.jpg");
	ImageIcon backIcon = new ImageIcon("cardPics\\back.jpg");
	//gui variables
	JLabel jL_card1_p1 = new JLabel(backIcon);
	JLabel jL_card2_p1 = new JLabel(defaultIcon);
	JLabel jL_card3_p1 = new JLabel(defaultIcon);
	JLabel jL_card1_p2 = new JLabel(backIcon);
	JLabel jL_card2_p2 = new JLabel(defaultIcon);
	JLabel jL_card3_p2 = new JLabel(defaultIcon);
	

	JLabel jL_name1 = new JLabel("You");
	JLabel jL_name2 = new JLabel("Computer");
	
	/**
	*	initialized the GUI and player hands.
	*/
	public GameFrame() {
		initGUI();
		initHands(p1,p2,undealtDeck);
	}
	
	private void initGUI() {

	//initialize GUI settings
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(layout);
		setTitle("The Game of War");
		
	//hide all card slots initially
		jL_card1_p1.setVisible(true);
		jL_card2_p1.setVisible(false);
		jL_card3_p1.setVisible(false);
		jL_card1_p2.setVisible(true);
		jL_card2_p2.setVisible(false);
		jL_card3_p2.setVisible(false);
		layout.setHonorsVisibility(false);

	//interactive buttons with tooltip popups
		JButton jB_endGame = new JButton("end game");
		jB_endGame.setToolTipText("quit to main menu");
		JButton jB_flipNext = new JButton("next card");
		jB_flipNext.setToolTipText("play next hand");	
		JButton jB_showScore = new JButton("show score");
		jB_showScore.setToolTipText("display number of cards you and your opponent has");
		JButton jB_restart = new JButton("restart");
		jB_restart.setToolTipText("redeal cards and start a new game");
		
	//automatic gap insertion
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.linkSize(SwingConstants.HORIZONTAL,jB_endGame,jB_flipNext,jB_restart,jB_showScore);	
		
	//setup listeners for interactive buttons
		jB_endGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_endGameActionPerformed(evt);
			}
		} );
		
		jB_flipNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_flipNextActionPerformed(evt);
			}
		} );
		
		jB_showScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_showScoreActionPerformed(evt);
			}
		} );
		
		jB_restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jB_restartActionPerformed(evt);
			}
		} );	
		
		
	// name1	 card1_p1 		card2_p1 		card3_p1
	// name2	 card1_p2 		card2_p2 		card3_p2
	// showScoreButton	 	  	nextCardButton	exitButton
	
	//setup horizontal groups
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jL_name1)
				.addComponent(jL_name2)
				.addComponent(jB_endGame))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jL_card1_p1)
				.addComponent(jL_card1_p2)
				.addComponent(jB_restart))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jL_card2_p1)
				.addComponent(jL_card2_p2)
				.addComponent(jB_flipNext))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(jL_card3_p1)
				.addComponent(jL_card3_p2)
				.addComponent(jB_showScore));
		
		//setup vertical groups
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(jL_name1)
				.addComponent(jL_card1_p1)
				.addComponent(jL_card2_p1)
				.addComponent(jL_card3_p1))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(jL_name2)
				.addComponent(jL_card1_p2)
				.addComponent(jL_card2_p2)
				.addComponent(jL_card3_p2))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(jB_endGame)
				.addComponent(jB_restart)
				.addComponent(jB_flipNext)
				.addComponent(jB_showScore));
				
		layout.setVerticalGroup(vGroup);
		layout.setHorizontalGroup(hGroup);
		
		pack();
	}
	
	/**
	*	updates the GUI for eac round when there is not a tie (i.e. war)
	*/
	private void updateGUI(String icon1, String icon2) {
		ImageIcon img1 = new ImageIcon("cardPics\\" + icon1 + ".jpg");
		ImageIcon img2 = new ImageIcon("cardPics\\" + icon2 + ".jpg");
		jL_card1_p1.setIcon(img1);
		jL_card1_p2.setIcon(img2);
		//this.repaint();
		//this.revalidate();
	}
	
	/**
	*	updates the GUI in the 'war' situation thereby placing the next two cards on the table.
	*	@param icon1-4 the string names of the card images
	*/
	private void updateGUI2(String icon1, String icon2, String icon3, String icon4) {
		ImageIcon img1 = new ImageIcon("cardPics\\" + icon1 + ".jpg");
		ImageIcon img2 = new ImageIcon("cardPics\\" + icon2 + ".jpg");
		ImageIcon img3 = new ImageIcon("cardPics\\" + icon3 + ".jpg");
		ImageIcon img4 = new ImageIcon("cardPics\\" + icon4 + ".jpg");
		jL_card1_p1.setIcon(img1);
		jL_card1_p2.setIcon(img2);
		jL_card3_p1.setIcon(img3);
		jL_card3_p2.setIcon(img4);
		jL_card2_p1.setIcon(backIcon);
		jL_card2_p2.setIcon(backIcon);
		
		jL_card3_p1.setVisible(true);
		jL_card3_p2.setVisible(true);
		jL_card2_p1.setVisible(true);
		jL_card2_p2.setVisible(true);
		
		this.repaint();
		this.revalidate();
	}
	
	/**
	*	hides card spaces that are not in play. Is called after the resolution of a 'war' tie.
	*/
	private void hideUIelements() {
		jL_card3_p1.setVisible(false);
		jL_card3_p2.setVisible(false);
		jL_card2_p1.setVisible(false);
		jL_card2_p2.setVisible(false);
	}
	
	/**
	*	initialize both players hands by randomly dealing them 26 cards each from full deck of cards.
	*	@param Player - the first player
	*	@param Player - the second player
	*	@param Deck - a full deck containing all 52 values
	*/
	private void initHands(Player p1, Player p2, Deck unshuffledDeck) {
		System.out.println("DeckSize:" +undealtDeck.getSize());
		Random randCard = new Random();
		int n = 0;
		for ( int iCount = 0; iCount < 52 ; iCount ++ ) {
			System.out.println(n);
			n++;
			
			switch( iCount % 2) {
				case 0: p1.addToHand(undealtDeck.dealCard(randCard.nextInt(unshuffledDeck.getSize())));
					break;
				case 1: p2.addToHand(undealtDeck.dealCard(randCard.nextInt(unshuffledDeck.getSize())));
			}
		}
	}
	
	
	/**
	*	The following are the various methods that control the interactive buttons
	*/
	
	//show the current score in a popup
	private void jB_showScoreActionPerformed(ActionEvent evt) {
		int score = p1.getHandTotal();
		JOptionPane scorePane = new JOptionPane();
		String scoreStr = "Your Score is " + score + "\nafter " + numRounds + " Rounds\n And your opponents score is " + p2.getHandTotal();
		JOptionPane.showMessageDialog(null,scoreStr);
	}
	
	// redeal and restart the game
	private void jB_restartActionPerformed(ActionEvent evt) {
		this.dispose();
		GameFrame gFrame2 = new GameFrame();
		gFrame2.setVisible(true);
	}
	
	//exit the program
	private void jB_exitProgActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	//end the game
	private void jB_endGameActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	//the primary source for the program's logic is here in the 'Flip Next' button 
	private void jB_flipNextActionPerformed(ActionEvent evt) {
		
		//if both players still have cards (i.e. game isn't over), continue
		if (!(p1.isEmpty()) && !(p2.isEmpty())) {
			numRounds++;
			
			//draw next cards
			Card c1 = p1.returnNextCard(0);
			Card c2 = p2.returnNextCard(0);
			
			//update gui			
			updateGUI(c1.getImage(), c2.getImage());
			hideUIelements();
	
			//check for winner
			if (c1.value > c2.value) { //p1 has won the hand
				p1.addToHand(c2);
				p1.addToHand(c1);
				p2.removeFromHand();
				p1.removeFromHand();
			}
			if (c1.value < c2.value ) { //p2 has won the hand
				p2.addToHand(c1);
				p2.addToHand(c2);
				p1.removeFromHand();
				p2.removeFromHand();
			}
			if (c1.value == c2.value ) {		 //it is a war situation, inform the user
				JOptionPane infoPane = new JOptionPane();
				JOptionPane.showMessageDialog(null, "It's a War!");
				
				//get the next cards to be tested
				Card nextCard1 = p1.returnNextCard(2);
				Card nextCard2 = p2.returnNextCard(2);
				String StringImg1 = nextCard1.getImage();
				String StringImg2 = nextCard2.getImage();
				
				//update the gui with these new cards
				updateGUI2(c1.getImage(),c2.getImage(),p1.returnNextCard(2).getImage(),p2.returnNextCard(2).getImage());
				//retest cards to deterime winner 
				if (nextCard1.value > nextCard2.value) {
					p1.addToHand(nextCard2);
					p1.addToHand(p2.returnNextCard(1));
					p1.addToHand(c2);
					p2.removeFromHand();
					p2.removeFromHand();
					p2.removeFromHand();
				}
				else if (nextCard1.value < nextCard2.value) {
					p2.addToHand(nextCard1);
					p2.addToHand(p1.returnNextCard(1));
					p2.addToHand(c1);
					p1.removeFromHand();
					p1.removeFromHand();
					p1.removeFromHand();
				}
				else { //avoid an infinite loop by moving top two cards 
						//to back of the deck in case of a tie
					p1.addToHand(p1.returnNextCard(0));
					p1.addToHand(p1.returnNextCard(1));
					p2.addToHand(p2.returnNextCard(0));
					p2.addToHand(p1.returnNextCard(1));
					p1.removeFromHand();
					p1.removeFromHand();
					p2.removeFromHand();
					p2.removeFromHand();
				}
			}
		}
		
		//else, in the case of no more cards existing for a particular player, display end of game message
		else {
			int score = p1.getHandTotal();
			JOptionPane scorePane = new JOptionPane();
			String scoreStr = "Your Score is " + score + "\nafter " + numRounds + " Rounds.\n Restart the game to try again.";
			JOptionPane.showMessageDialog(null,scoreStr);
		}
	}	

}