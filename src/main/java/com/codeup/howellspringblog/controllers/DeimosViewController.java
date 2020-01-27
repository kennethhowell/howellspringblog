package com.codeup.howellspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeimosViewController {

    @GetMapping("/deimos/{days}")
    public String deimosDays(@PathVariable String days, Model model){
        model.addAttribute("days", days);
        return "deimosdays";
    }

}
