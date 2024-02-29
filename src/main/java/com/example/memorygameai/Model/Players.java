package com.example.memorygameai.Model;

/**
 * Class for both players. Since they both see the same cards, and we are assuming optimal play, there is no need for each player to
 * remember their cards individually.
 */
public class Players {

    private int player1points;
    private int player2points;
    private int[] seenCards;

    public int getPlayer1points() {
        return player1points;
    }

    public void setPlayer1points(int player1points) {
        this.player1points = player1points;
    }

    public int getPlayer2points() {
        return player2points;
    }

    public void setPlayer2points(int player2points) {
        this.player2points = player2points;
    }

    public int[] getSeenCards() {
        return seenCards;
    }

    public void addPointPlayer1() {
        player1points++;
    }

    public void addPointPlayer2() {
        player1points++;
    }

    public void setSeenCards(int[] seenCards) {
        this.seenCards = seenCards;
    }

    public Players(int pairNr) {
        this.player1points = 0;
        this.player2points = 0;
        this.seenCards = new int[pairNr];
        for (int i = 0; i < pairNr; i++) {
            this.seenCards[i] = -1;
        }
    }

    public void rememberCard(int value) {
        for (int i = 0; i < this.seenCards.length; i++) {
            if (seenCards[i] == -1) {
                this.seenCards[i] = value;
                break;
            }
        }
    }

    /**
     * Checks for a pair in the seen cards
     * @param value the value of searched card
     * @return index of the found pair, -1 if no pair is found
     */
    public int checkForPair(int value) {
        for (int i = 0; i < this.seenCards.length; i++) {
            if (this.seenCards[i] == value) {
                return this.seenCards[i];
            }
        }

        return -1;
    }
}
