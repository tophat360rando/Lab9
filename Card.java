import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    // Create a card with a rank and suit
    public Card(Rank rank, Suit suit) {
        this.rank = Objects.requireNonNull(rank);
        this.suit = Objects.requireNonNull(suit);
    }

    // Return the rank
    public Rank getRank() {
        return rank;
    }

    // Return the suit
    public Suit getSuit() {
        return suit;
    }

    // Compare cards by suit first, then rank
    @Override
    public int compareTo(Card other) {
        int suitComparison = suit.compareTo(other.suit);

        if (suitComparison != 0) {
            return suitComparison;
        }

        return rank.compareTo(other.rank);
    }

    // Check whether two cards have the same rank and suit
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }

        Card other = (Card) obj;

        return rank == other.rank && suit == other.suit;
    }

    // Return a hash code based on the rank and suit
    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    // Return the card symbol
    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }
}