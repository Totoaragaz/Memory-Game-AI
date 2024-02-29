package com.example.memorygameai.Model;

/**
 * Class for both players. Since they both see the same cards, and we are assuming optimal play,
 * there is no need for each player to remember their cards individually.
 */
public class Players {

    private int player1points;
    private int player2points;

    /**
     * The cards seen by both players. -2 means the pair was found, -1 is an unknown card, a positive number is
     * the value of the card
     */
    private int[] seenCards;
    private int seenCardNumber;

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
    public int getSeenCardNumber() {
        return seenCardNumber;
    }

    public void increaseSeenCards() {
        this.seenCardNumber++;
    }

    public void addPointToPlayer(int player) {
        if (player == 1) {
            player1points++;
        } else {
            player2points++;
        }
    }

    public void setSeenCards(int[] seenCards) {
        this.seenCards = seenCards;
    }

    public Players(int pairNr) {
        this.player1points = 0;
        this.player2points = 0;
        this.seenCardNumber = 0;
        this.seenCards = new int[pairNr * 2];
        for (int i = 0; i < pairNr * 2; i++) {
            this.seenCards[i] = -1;
        }
    }

    public void rememberCard(int index, int value) {
        this.seenCards[index] = value;
    }

    /**
     * Checks for a pair in the seen cards
     * @return indexes of the found pair, [] if no pair is found
     */
    public int[] checkForPair() {
        for (int i = 0; i < this.seenCards.length - 1; i++) {
            if (this.seenCards[i] >= 0) {
                for (int j = i + 1; j < this.seenCards.length; j++) {
                    if (this.seenCards[i] == this.seenCards[j]) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public void removePair(int index1, int index2) {
        this.seenCards[index1] = -2;
        this.seenCards[index2] = -2;
    }
}
