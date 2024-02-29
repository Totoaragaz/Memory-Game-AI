package com.example.memorygameai.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    public void createCardsTest(){
        Cards game = new Cards(3);
        int[] cards = {0,0,1,1,2,2};
        Assertions.assertArrayEquals(cards, game.getCards());
    }
}