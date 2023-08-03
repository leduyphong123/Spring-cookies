package com.codegym.cookies.controller;

import com.codegym.cookies.entity.Acount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class AcountController {

    @GetMapping("")
    public String viewLogin(Model model){
        model.addAttribute("acount",new Acount());
        return "login";
    }
//    @PostMapping()
//    public ModelAndView viewHome(@ModelAttribute Acount acount, HttpServletResponse response){
//        if (acount.getEmail().equals("admin") && acount.getPassword().equals("admin")){
//            String token = "12321321";
//            Cookie cookie  = new Cookie("token",token);
//            response.addCookie(cookie);
//            return new ModelAndView("home");
//        }
//        return new ModelAndView("login");
//    }
@PostMapping()
public ModelAndView viewHome(@CookieValue(value = "token",defaultValue = "") String token, @ModelAttribute Acount acount, HttpServletResponse response){
    if (acount.getEmail().equals("admin") && acount.getPassword().equals("admin")){
         token = "12321321";
        Cookie cookie  = new Cookie("token",token);
        response.addCookie(cookie);
        return new ModelAndView("home");
    }
    return new ModelAndView("login");
}
}
