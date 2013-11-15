public class Deck {
	final int NUM_CARDS = 52;
	final int NUM_CARD_LOCATIONS = 3 				// 1)in the deck (not dealt or burned), 2)dealt to a player, or 3)discarded to the burn pile
	private Card[][] cardDeck = new Card[NUM_CARDS][NUM_CARD_LOCATIONS];
	private Stack[]
	
	//default constructor
	public Deck() {
		
	}
	
	/** shuffle. 
	*	@param unshuffledDeck is an ArrayList containing all cards in the deck
	* 	@return Queue of random unsorted cards
	*/
	public Queue shuffle(ArrayList unshuffledDeck) {
	
	}
	
	/** shuffle (overloaded to return known card stackorder). 
	*	@param integer to determine which preset stack to return
	*	@return stack of cards in known order for debugging)
	*/
	public Stack shuffle(int preset) {
	
	}
	
	/** draw top card from undealt stack 
	*	@return  Card from top of stack
	*/
	public Card drawCard() {
	
	}

	/** dealCards 
	*/
	public Hand dealCards(int numPlayers, int cardsPerPlayer) {
		
	}
	
	/** createHands to be dealt by Deal Cards
	*	@param numPlayers is the integer number of players in the game 
	*	@param cardsPerPlayer is the initial number of cards in a hand
	*/
	private createHands(int numPlayers, int cardsPerPlayer) {
	
	}
	
	/** cutDeck. 
	*	@param place to cut deck (1-52)
	*	set new 'head' on deck stack but maintain card order*/
	public void cutDeck(int newStart) {
	
	}
	
	/** trackCards
	*	track cards so duplicates cannot be dealt from draw pile
	*	@param card is the card being  moved to new location
	*	@param location is the place where the card was moved (hand,burn,draw
	*/
	private void trackCards(Card card, String location) {
		
	}
	
	//need to add ability to use multiple decks
	//need to add array of dealt vs burned vs drawpile cards
}