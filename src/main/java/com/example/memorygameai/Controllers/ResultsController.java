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
                          Model model) {

        GameController gameController = new GameController();
        int winner = gameController.playGame(Integer.parseInt(pairNr));
        model.addAttribute("winner", winner);
        return "results";
    }
}
