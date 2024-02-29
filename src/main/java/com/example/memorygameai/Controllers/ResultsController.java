package com.example.memorygameai.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultsController {

    @RequestMapping("/results")
    public String results(@RequestParam(value = "pairNr", required = true) String pairNr,
                          @RequestParam(value = "gameNr", required = true) String gameNr,
                          Model model)
    {
        boolean invalidArguments = false;
        try {
            if (Integer.parseInt(pairNr) < 1 || Integer.parseInt(gameNr) < 1) {
                invalidArguments = true;
            }
        } catch (Exception e){
            invalidArguments = true;
        }

        if (invalidArguments) {
            return "index";
        } else {
            model.addAttribute("pairNr", pairNr);
            model.addAttribute("gameNr", gameNr);


            int[] wins = simulateGames(Integer.parseInt(pairNr), Integer.parseInt(gameNr));
            model.addAttribute("p1Wins", wins[1]);
            model.addAttribute("p2Wins", wins[2]);
            model.addAttribute("draws", wins[0]);

            return "results";
        }
    }

    private int[] simulateGames(int pairNr, int gameNr) {
        int[] wins = new int[3];
        GameController gameController = new GameController();
        for (int i = 0; i < gameNr; i++) {
            wins[gameController.playGame(pairNr)]++;
        }

        return wins;
    }
}
