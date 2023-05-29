package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Repository.loginrepo;
import com.example.demo.entity.details;


@Controller
public class login {

   @Autowired
   loginrepo repo;


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

      repo.save(details);
      
       return details;
    }

     
}
