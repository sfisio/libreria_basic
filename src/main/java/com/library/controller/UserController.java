package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/")
    public ModelAndView hello(Model model)
    {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "email", required = true) String email,
                        @RequestParam(value = "password", required = true) String password, Model model) {
        User user = userService.login(email, password);
        if(user != null){
            model.addAttribute("user",user);
            System.out.println(user.getName());
            return "forward:/viewBooksForUser";
        }
        return "login";
    }


}