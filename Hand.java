public class Hand {
	private int Score;
	private ArrayList<Integer> cardsInHand;
	final int NUM_CARDS_IN_HAND = 10; 	// if the number of cards in a hand varies (such as the game Uno),
										// 		this will have to bbe changed.
	/** Default constructor. */
	public Hand() {
	
	}
	
	/** computeScore. 
	* 	computes the value of the hand from the array cardsInHand
	*	@return the hand's value
	*/
	public int computeScore() {
	}
	
	/** sortHand. 
	*	sorts the hand (by value and suit, just by value? depends on game type
	*	@return an integer array of sorted values*/
	public int[] sortHand() {
	
	}
}