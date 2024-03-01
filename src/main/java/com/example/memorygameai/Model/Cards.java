package com.example.memorygameai.Model;

public class Cards {

    private int pairNr;
    private int[] cards;

    public int getPairNr() {
        return pairNr;
    }

    public int[] getCards() {
        return cards;
    }

    public Cards(int pairNr) {
        this.pairNr = pairNr;
        createCards();
    }

    /**
     * Creates the game itself. Cards do not need to be randomized as the players will guess randomly.
     */
    private void createCards() {
        this.cards = new int[pairNr * 2];
        for (int i = 0; i < pairNr * 2; i++) {
            this.cards[i] = i/2;
        }
    }
}
