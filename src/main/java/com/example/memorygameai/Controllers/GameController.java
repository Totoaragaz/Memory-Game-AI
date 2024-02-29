package com.example.memorygameai.Controllers;

import com.example.memorygameai.Model.Game;

public class GameController {

    private Game game;
    private int playerTurn;
    private boolean pairFound;

    public GameController() {
    }

    /**
     * Plays the game, Player 1 always starts
     * @return The number of the winning player, 0 for a draw
     */
    public int playGame(int pairNr) {
        this.game = new Game(pairNr);
        this.playerTurn = 1;
        this.pairFound = false;
        while (!this.game.isGameOver()) {
            playRound();
            if (!pairFound) {
                this.playerTurn = this.playerTurn % 2 + 1;
            }
        }

        if (this.game.getPlayers().getPlayer1points() > this.game.getPlayers().getPlayer2points()) {
            return 1;
        } else if (this.game.getPlayers().getPlayer1points() < this.game.getPlayers().getPlayer2points()) {
            return 2;
        }
        return 0;
    }

    private void playRound() {
        pairFound = false;
        int[] potentialPair = game.getPlayers().checkForPair();

        if (potentialPair != null) {
            guessPair(potentialPair);
        } else {
            int[] firstCard = guessRandomCard();
            int[] newPotentialPair = game.getPlayers().checkForPair();

            if (newPotentialPair != null) {
                guessPair(newPotentialPair);
            } else {
                int[] secondCard = guessRandomCard();

                if (firstCard[1] == secondCard[1]) {
                    guessPair(new int[]{firstCard[0], secondCard[0]});
                }
            }
        }
    }

    private int[] guessRandomCard() {
        int cardIndex = game.getRandomCardIndex();
        game.getPlayers().increaseSeenCards();
        int cardValue = game.getCards().getCards()[cardIndex];
        game.getPlayers().rememberCard(cardIndex, cardValue);
        return new int[]{cardIndex, cardValue};
    }

    private void guessPair(int[] pair) {
        game.getPlayers().removePair(pair[0], pair[1]);
        game.getPlayers().addPointToPlayer(playerTurn);
        game.addFoundPair();
        pairFound = true;
    }
}
