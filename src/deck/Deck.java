package deck;


import java.util.Arrays;

public class Deck {

    private final int DEFAULT_SIZE = 52;

    private int size;
    private Card[] cards;

    public Deck() {
        this.size = DEFAULT_SIZE;
        cards = new Card[52];

        int position = 0;
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                Card card = new Card(value, suit);
                cards[position] = card;
                position++;
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            int endPos = (int )(Math.random() * 52);
            swap(i, endPos);
        }
    }

    private void swap(int startPos, int endPos) {
        Card temp = cards[endPos];
        cards[endPos] = cards[startPos];
        cards[startPos] = temp;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "DEFAULT_SIZE=" + DEFAULT_SIZE +
                ", size=" + size +
                ", cards=" + Arrays.toString(cards) +
                '}';
    }
}
