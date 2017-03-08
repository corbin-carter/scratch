package deck;

public class Card {
    private CardValue value;
    private CardSuit cardSuit;

    public Card(CardValue value, CardSuit cardSuit) {
        this.value = value;
        this.cardSuit = cardSuit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", cardSuit=" + cardSuit +
                '}';
    }
}
