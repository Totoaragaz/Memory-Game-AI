package com.example.memorygameai.Model;

import java.util.Random;

public class Game {

    private Cards cards;

    private int foundPairs;
    private Players players;

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public int getFoundPairs() {
        return foundPairs;
    }

    public void setFoundPairs(int foundPairs) {
        this.foundPairs = foundPairs;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
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

    public int getRandomCardIndex() {
        Random rng = new Random();
        int index = rng.nextInt((cards.getPairNr() - foundPairs) * 2 + 1);
        for (int i = 0; i < cards.getCards().length; i++) {
            if (players.getSeenCards()[i] < 0) {
                index--;
            }
            if (index == 0) {
                return i;
            }
        }

        return -1;
    }
}
