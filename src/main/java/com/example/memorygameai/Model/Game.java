package com.example.memorygameai.Model;

public class Game {

    private Cards cards;
    private Players players;

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Game(int pairNr) {
        this.cards = new Cards(pairNr);
        this.players = new Players(pairNr);
    }
}
