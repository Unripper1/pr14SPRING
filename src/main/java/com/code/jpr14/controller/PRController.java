package com.code.jpr14.controller;

import com.code.jpr14.Address;
import com.code.jpr14.Building;

import com.code.jpr14.dao.AddressDAO;
import com.code.jpr14.dao.BuildingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class PRController {


    @GetMapping("/home")
    public String greeting() {
        return "home";
    }


}
@Controller
@RequestMapping("/buildings")
class BDController {
    private final BuildingDAO buildingDAO;

    public BDController(BuildingDAO buildingDAO) {
        this.buildingDAO = buildingDAO;
    }

    @GetMapping("/new")
    public String crForm(Model model) {
        model.addAttribute("building", new Building());
        return "createForm";
    }

    @GetMapping("/show")
    public String index(Model model) {
        model.addAttribute("buildings", buildingDAO.index());
        return "show";
    }

    @GetMapping("/{id}")
    public String del(@PathVariable("id") Long id) throws SQLException {
        buildingDAO.del(id);
        return "redirect:/buildings/show";
    }

    @PostMapping()
    public String create(@ModelAttribute("building") Building building) {
        buildingDAO.save(building);
        return "redirect:/buildings/show";
    }
}

@Controller
@RequestMapping("/addresses")
class ADController {
    private final AddressDAO addressDAO;

    public ADController(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }


    @GetMapping("/new")
    public String crForm(Model model) {
        model.addAttribute("building", new Address());
        return "createFormA";
    }

    @GetMapping("/show")
    public String index(Model model) {
        model.addAttribute("buildings", addressDAO.index());
        return "showA";
    }

    @GetMapping("/{id}")
    public String del(@PathVariable("id") Long id) {
        addressDAO.del(id);
        return "redirect:/addresses/show";
    }

    @PostMapping()
    public String create(@ModelAttribute("building") Address address) {
        addressDAO.save(address);
        return "redirect:/addresses/show";
    }
}