package com.code.jpr14.controller;

import com.code.jpr14.Address;
import com.code.jpr14.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PRController {
    @GetMapping("/home")
    public String greeting() {
        return "home";
    }

}