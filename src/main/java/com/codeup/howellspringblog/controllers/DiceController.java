package com.codeup.howellspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

//    int computerRoll = (int) (Math.random() * 6) + 1;


    @GetMapping("/roll-dice")
    public String showDiceForm(Model model){
        return "dicemustflow";
    }


    @GetMapping("/roll-dice/{number}")
    public String diceCheck(@PathVariable int number, Model model){
        int userRoll = number;
        int userCounter = 0;
        int computerRoll = (int) (Math.random() * 6) + 1;
        int computerRoll2 = (int) (Math.random() * 6) + 1;
        int computerRoll3 = (int) (Math.random() * 6) + 1;

        String diceresult = "";


        boolean dicegood = false;

        if (userRoll == computerRoll){
            dicegood = true;
            userCounter++;
        }
        if (userRoll == computerRoll2){
            dicegood = true;
            userCounter++;
        }
        if (userRoll == computerRoll3){
            dicegood = true;
            userCounter++;
        }

        if (dicegood){
            diceresult = "Good job! You guessed " + userRoll + " and the computer's rolls were " + computerRoll + ", " + computerRoll2 + ", and " + computerRoll3 + ". You matched " + userCounter + " rolls!";
        } else {
            diceresult = "Bummer dude, you guessed " + userRoll + " and the computer's rolls were " + computerRoll + ", " + computerRoll2 + ", and " + computerRoll3 + ".";
        }

        model.addAttribute("diceresult", diceresult);

        return "dicemustflow";
    }

}
