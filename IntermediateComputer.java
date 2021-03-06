public class IntermediateComputer extends Computer
{
	private final static double DECK_EXPECTED_VALUE = 5;
	private final static double MIN_HAND_VALUE = 10.0;
	
	public IntermediateComputer()
	{
		super();
	}
	
	/**
		Method chooses a pile (Draw Pile or Discard Pile) to take a card from or declares RAT-A-TAT-CAT
		@param deck The deck
		@param finalTurn A boolean value indicating whether the human declared RAT-A-TAT-CAT on his/her
		previous turn
		@return An integer representing the pile that the computer would like to take a card from or 
		the computer's decision to declare RAT-A-TAT-CAT

	*/
	
	public int choosePile(Deck deck, boolean finalTurn)
	{
		if(!finalTurn && getHandValue(DECK_EXPECTED_VALUE) < MIN_HAND_VALUE)
		{
			return Game.RAT_A_TAT_CAT;
		}
		else
		{
			return getPile(deck, DECK_EXPECTED_VALUE);
		}
	}
	
	/**
		Method returns the computer's move (where to place the drawn card)
		@param deck The deck
		@param choice The computer's chosen pile to take a card from (Draw Pile or Discard Pile)
		@return An integer representing the computer's chosen move
	*/
	
	public int chooseMove(Deck deck, int choice)
	{
		return getMove(deck, choice, DECK_EXPECTED_VALUE);
	}
	
	/**
		Method updates the computer's memory after the human makes a swap
		@param computerIndex The index of the card in computer's hand that swap occurred
		@param humanIndex The index of the card in the human's hand that swap occurred
	*/
	
	public void recordHumanSwap(int computerIndex, int humanIndex)
	{
		setCompMemory(computerIndex, null);
	}
	
	/**
		Method simulates when the computer picks a draw 2 card
		@param deck The deck
		@param opponent The computer's opponent
		@return DrawTwo object which keeps track of computer's moves during Draw 2 turn
	*/
	
	public DrawTwo draw2(Deck deck, Player opponent)
	{
		return super.draw2(deck, opponent);
	}
	
	/**
		Method swaps a card in the computer's hand with a card in the human's hand
		@param The computer's opponent (human)
		@return Swap object detailing what occurred during swap
	*/
	
	public Swap swap(Player opponent)
	{
		int computerCard = getHighestValuedCard(DECK_EXPECTED_VALUE);
		int opponentCard = (int)(Math.random() * Hand.NUM_CARDS);
		swapWithOpponent(opponent, opponentCard, computerCard);
		setCompMemory(computerCard, null);
		return new Swap(computerCard, opponentCard);
	}
	
	/**
		Method enables computer to peek at an unknown card
		@return index of the card that the computer peeked at
		@return -1 If the computer did not peek at any cards
	*/
	
	public int peek()
	{
		return super.peek();
	}
	
	/**
		Method returns a boolean value indicating whether the computer would like to use a swap card
		if it is the first card drawn after picking a draw 2 card
		@return true If the computer would like to use the swap card
		@return false If the computer would not like to use the swap card
	*/
	
	public boolean useSwap()
	{
		if(getHighestValuedCard(DECK_EXPECTED_VALUE) >= DECK_EXPECTED_VALUE)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
		Method returns a boolean value indicating whether tha computer would like to use a peek card
		if it the first card drawn after picking a draw 2 card
		@return true If the computer would like to use the peek card
		@return false If the computer would not like to use the peek card
	*/
	
	public boolean usePeek()
	{
		return super.usePeek();
	}

}
