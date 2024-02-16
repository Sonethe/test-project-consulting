package com.example.testprojectconsulting.controllers;

import com.example.testprojectconsulting.DAO.TextProcessingDAO;
import com.example.testprojectconsulting.models.TextProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class MainController {
    public TextProcessingDAO textProcessingDAO;

    @Autowired
    public MainController(TextProcessingDAO textProcessingDAO) {
        this.textProcessingDAO = textProcessingDAO;
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("inputText", new TextProcessing());
        model.addAttribute("hasText", textProcessingDAO.getCheck());
        model.addAttribute("text", textProcessingDAO.getText());
        model.addAttribute("charMap", textProcessingDAO.getCharMap());

        return "home";
    }

    @PostMapping()
    public String checker(@ModelAttribute("inputText") TextProcessing textProcessing) {
        textProcessingDAO.setText(textProcessing.getInpText());
        textProcessingDAO.allChars();

        return "redirect:/home";
    }
}
