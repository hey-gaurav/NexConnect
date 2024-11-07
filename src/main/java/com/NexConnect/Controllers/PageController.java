package com.NexConnect.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page");
        //sending data to view
        model.addAttribute("Name", "Gaurav Singh");
        model.addAttribute("Age", "25");
        model.addAttribute("Gender", "Male");
        return "home";
    }
}