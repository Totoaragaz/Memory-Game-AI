package com.example.memorygameai.Model;

import java.util.Random;

public class Game {

    private Cards cards;

    private int foundPairs;
    private Players players;

    public Cards getCards() {
        return cards;
    }

    public Players getPlayers() {
        return players;
    }

    public Game(int pairNr) {
        this.cards = new Cards(pairNr);
        this.foundPairs = 0;
        this.players = new Players(pairNr);
    }

    public boolean isGameOver() {
        return foundPairs == this.cards.getPairNr();
    }

    public void addFoundPair() {
        this.foundPairs++;
    }

    /**
     * Gets the index of a random card that has not yet been seen
     * @return the index of the card
     */
    public int getRandomCardIndex() {
        Random rng = new Random();
        int index = rng.nextInt(cards.getPairNr() * 2 - players.getSeenCardNumber());
        for (int i = 0; i < cards.getCards().length; i++) {
            if (players.getSeenCards()[i] == -1) {
                if (index == 0) {
                    return i;
                }
                index--;
            }
        }

        return cards.getCards().length - 1;
    }
}
