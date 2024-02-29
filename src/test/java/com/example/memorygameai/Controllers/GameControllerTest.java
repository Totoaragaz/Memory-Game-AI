package com.example.memorygameai.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    public void oneRoundGameTest() {
        GameController gameController = new GameController(1);
        assertEquals(1, gameController.playGame());
    }

}