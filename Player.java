import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
*	The player class stores the card hand information for each player
*/
public class Player {

	ArrayList<Card> playerHand = new ArrayList<Card>();

	private final int CARDS_PER_HAND = 26;
	
	//default constructor
	public Player() {
	
	}
	
	/**AddToHand - Adds card to back of the players hand
	*@param Card cardIn - the card being added
	*/
	public void addToHand(Card cardIn) {
		playerHand.add(cardIn);
	}
	
	/**returnNextCard - returns the Card at the queried index, but does not remove
	*@param int i - the index card being queried
	*@return Card - a card object held in the hand
	*/
	public Card returnNextCard(int i) {
		if (playerHand.isEmpty())
			return null;
		else
			return playerHand.get(i);
	}
	
	/**removeFromHand - removes the top card from the hand
	*/
	public void removeFromHand() {
		playerHand.remove(0);
	}

	/**isEmpty() - returns if the hand is empty
	*@return boolean if the hand is empty
	*/
	public boolean isEmpty() {
		return playerHand.isEmpty();
	}
	
	/**getHandTotal - returns the number of cards left in the hand
	*@return int - number of cards
	*/
	public int getHandTotal() {
		return playerHand.size();
	}
}	