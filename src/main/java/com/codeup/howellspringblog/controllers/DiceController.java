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
        int computerRoll = (int) (Math.random() * 6) + 1;
        String diceresult = "";


        boolean dicegood = computerRoll == userRoll;

        if (dicegood){
            diceresult = "Good job! You rolled " + userRoll + " and the computer's roll was " + computerRoll;
        } else {
            diceresult = "Bummer dude, you rolled " + userRoll + " and the computer's roll was " + computerRoll;
        }

        model.addAttribute("diceresult", diceresult);

        return "dicemustflow";
    }

}
