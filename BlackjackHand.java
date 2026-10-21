import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BlackjackHand {

    private static final int MAX_VALUE = 21;

    private static final Map<Rank, Integer> CARD_VALUES;

    private final List<Card> cards;
    private int value;
    private int numAcesAs11;

    // Set the values for every card rank
    static {
        CARD_VALUES = new HashMap<>();

        for (Rank rank : Rank.values()) {
            if (rank.ordinal() <= Rank.TEN.ordinal()) {
                CARD_VALUES.put(rank, rank.ordinal() + 2);
            } else if (rank == Rank.ACE) {
                CARD_VALUES.put(rank, 11);
            } else {
                CARD_VALUES.put(rank, 10);
            }
        }
    }

    // Create a hand containing two cards
    public BlackjackHand(Card card1, Card card2) {
        cards = new ArrayList<>();
        value = 0;
        numAcesAs11 = 0;

        addCard(card1);
        addCard(card2);
    }

    // Add a card if the hand is worth less than 21
    public void addCard(Card card) {
        Objects.requireNonNull(card);

        if (value < MAX_VALUE) {
            cards.add(card);

            int cardValue = CARD_VALUES.get(card.getRank());
            value += cardValue;

            if (card.getRank() == Rank.ACE) {
                numAcesAs11++;
            }

            // Change aces from 11 to 1 when needed
            while (value > MAX_VALUE && numAcesAs11 > 0) {
                value -= 10;
                numAcesAs11--;
            }
        }
    }

    // Return a copy of the card values map
    public static Map<Rank, Integer> getCardValues() {
        return new HashMap<>(CARD_VALUES);
    }

    // Return a copy of the cards in the hand
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    // Return the total value of the hand
    public int getValue() {
        return value;
    }

    // Return the number of cards in the hand
    public int size() {
        return cards.size();
    }

    // Return the hand as a string
    @Override
    public String toString() {
        return cards.toString();
    }
}