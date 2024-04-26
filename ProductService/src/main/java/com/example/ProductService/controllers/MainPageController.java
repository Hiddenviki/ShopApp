package com.example.ProductService.controllers;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class MainPageController{

    @GetMapping("/main")
    public String mainPage() {
        log.info("------------------MAIN MAIN MAIN------------------");
        return "main_page";
    }



//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @GetMapping("/signup")
//    public String signupPage() {
//        return "signup";
//    }

}
