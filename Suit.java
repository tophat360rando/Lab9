public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String symbol;

    // Create a suit with its symbol
    Suit(String symbol) {
        this.symbol = symbol;
    }

    // Return the suit symbol
    @Override
    public String toString() {
        return symbol;
    }
}