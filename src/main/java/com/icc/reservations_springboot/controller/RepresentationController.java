package com.icc.reservations_springboot.controller;

import java.util.List;

import com.icc.reservations_springboot.model.Representation;
import com.icc.reservations_springboot.service.RepresentationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class RepresentationController {
    @Autowired
    RepresentationService service;

    @GetMapping("/representations")
    public String index(Model model) {
        List<Representation> representations = service.getAll();

        model.addAttribute("representations", representations);
        model.addAttribute("title", "Liste des representations");

        return "representation/index";
    }

    @GetMapping("/representations/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Representation representation = service.get(id);

        model.addAttribute("representation", representation);
        model.addAttribute("date", representation.getWhen().toLocalDate());
        model.addAttribute("heure", representation.getWhen().toLocalTime());
        model.addAttribute("title", "Fiche d'une representation");

        return "representation/show";
    }

}
