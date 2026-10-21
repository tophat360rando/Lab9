import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    // Create a deck containing all 52 cards in sorted order
    public Deck() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    // Remove and return the first card
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }

        return cards.remove(0);
    }

    // Remove and return the requested number of cards
    public List<Card> draw(int count) {
        List<Card> drawnCards = new ArrayList<>();

        if (count <= 0) {
            return drawnCards;
        }

        while (count > 0 && !cards.isEmpty()) {
            drawnCards.add(cards.remove(0));
            count--;
        }

        return drawnCards;
    }

    // Randomize the order of the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Return the number of cards remaining
    public int size() {
        return cards.size();
    }

    // Return all cards as a string
    @Override
    public String toString() {
        return cards.toString();
    }

    // Return the cards matching the given rank
    public List<Card> getCardsByRank(Rank rank) {
        List<Card> matchingCards = new ArrayList<>();

        for (Card card : cards) {
            if (card.getRank() == rank) {
                matchingCards.add(card);
            }
        }

        return matchingCards;
    }
}