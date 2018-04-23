package com.training.Basics1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NamesViewController {

    public List<String> names = new ArrayList<>();

    @GetMapping("/view/getName")
    public String getNamesView(Model model) {
        model.addAttribute("names", names);
        return "names";
    }

    @GetMapping("/view/addName")
    public String addName(@RequestParam String name) {
        names.add(name);
        return "redirect:/view/getName";
    }

}
