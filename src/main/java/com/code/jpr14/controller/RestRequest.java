package com.code.jpr14.controller;

import com.code.jpr14.Address;
import com.code.jpr14.Building;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestRequest {
    List<Address> listA = new ArrayList<>();
    List<Building> listB = new ArrayList<>();
    @RequestMapping("/job")
    public String classJob(HttpServletRequest request) {
        String aClass = request.getParameter("class");
        String command = request.getParameter("command");
        if (aClass.equals("address")) {
            if (command.equals("del")) {
                listA.remove(0);
                System.out.println(listA.toString());
                return aClass + " del";

            }
            if (command.equals("add")) {
                listA.add(new Address());
                System.out.println(listA.toString());
                return aClass + " added";

            }
        }

        if (aClass.equals("building")) {
            if (command.equals("del")) {
                listB.remove(0);
                return aClass + " del";
            }
            if (command.equals("add")) {
                listB.add(new Building());
                return aClass + " added";
            }

        }
        if (command.equals("show") && aClass.equals("address")) {
            return listA.toString();
            //return context.getBeanNamesForType(Address.class).toString();
        }
        if (command.equals("show") && aClass.equals("building")) {
            return listA.toString();
            // return context.getBeanNamesForType(Building.class).toString();
        }
        return aClass;
    }
}

