package com.NexConnect.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


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

    //About Route
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "About";
    }
    
    //Services Route
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        return "Services";
    }
}