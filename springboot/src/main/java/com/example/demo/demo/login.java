package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class login {


   // details details;

    @GetMapping("/login")
    public String login()
    {
       return "login";
    }



    @PostMapping("/success")
   @ResponseBody
    public details details(details details)
     {
       return details;
    }

     



    
  
    
}
