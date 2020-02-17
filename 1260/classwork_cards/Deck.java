import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Deck
{
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int nextCard;

    public Deck()
    {
        for(int i = 1; i <= 52; i++)
        {
            Card card = new Card(i);
            this.deck.add(card);
        }
    }

    public Deck(ArrayList<Card> existingDeck)
    {
        for(int i = 1; i < 53; i++)
        {
            this.deck.add(existingDeck.get(i));
        }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public Card dealACard()
    {
        Card cardToReturn = deck.get(nextCard);
        this.nextCard++;
        return cardToReturn;
    }

    public String dealAHand(int handSize)
    {
        StringBuilder string = new StringBuilder();
        for(int i = 1; i <= handSize; i++)
        {
            Card someCard = dealACard();
            string.append("\n" + someCard.toString());;
        }
        return string.toString();
    }

    public String toString()
    {
        StringBuilder string = new StringBuilder();
        for(int i = 1; i < deck.size(); i++)
        {
            string.append("\n" + deck.get(i).toString());
        }
        return string.toString();
    }

}