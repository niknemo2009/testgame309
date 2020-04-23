package com.example.grey.cards_309.Model;

public class Card {
    Suit suit;
    VALUE_CARD value;
    String picture;

    public Card(Suit suit, VALUE_CARD value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}

enum  Suit{
    Spades,Diamond,Hearts,Clubs
}
enum VALUE_CARD {
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
    int value;

    VALUE_CARD(int value) {
        this.value = value;
    }
}
