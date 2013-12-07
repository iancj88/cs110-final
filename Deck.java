/** The Deck class facilitates the use of a full 52 card deck
*
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deck {
	final int CARDS_PER_DECK = 52;
	public ArrayList<Card> unshuffledDeck = new ArrayList<Card>();

	/** Default Constructor
	*	Automatically seeds the deck with 52 Cards in order
	*/
	public Deck() {
		for (int i = 0; i < CARDS_PER_DECK; i++) {
			Card c1 = new Card(i);
			unshuffledDeck.add(c1);
		}
	}
	
	/**getSize
	*@return int number of objects held in the deck
	*/
	public int getSize() {
		return unshuffledDeck.size();
	}
	
	/**dealCard -
	* @param int i - the index of the card to be dealt/returned
	* @return Card - the card object being returned
	*/
	public Card dealCard(int i) {
		Card c1 = unshuffledDeck.get(i);
		unshuffledDeck.remove(i);
		return c1;
	}
}