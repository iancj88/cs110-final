public class Card 	{
	//has a suit
	//has a value
	//has string (Ace,King,Queen,...,two)
	//	Suit Rankings: Spades,Diamonds,Hearts,Clubs. (https://tinyurl.com/YahooAns-Source)

	private enum Suit { HEARTS, DIAMONDS, SPADES, CLUBS };
	private int value;
	private String strVal;
	
	/** Default Constructor (Random value). */
	public Card() {
		
	}
	
	/** Explicit Constructor (Explicit value) */ 
	public Card() {
	
	}
	
	/** equals. 
	*	@param Card to compare to this one
	*	@return true if cards are same suit & value
	*/
	public boolean equals(Card card_in) {
	
	}
	
	/** compareVal. 
	*	@param Card to compare to this one
	*	@return 1 if this card is greater,
	*			0 if they are equal, and
	*		   -1 if this card is less. 
	*/
	public int compareVal(Card card_in) {
	
	}
	
	/** Getters. */
	public enum<?> getSuit() {
	
	}
	
	public String getStrVal() {
	
	}
	
	public int getVal() {
	
	}
	
	
	/** Setters (i.e. cheatmode). */
	
	public  void setSuit(Suit suit) {
	
	}
	
	public void setVal(int val) {
	
	}
	
	public void setVal(String str) {
	
	}
	
}