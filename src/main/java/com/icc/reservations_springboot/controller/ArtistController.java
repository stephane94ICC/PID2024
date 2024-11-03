package com.icc.reservations_springboot.controller;

import java.util.List;

import com.icc.reservations_springboot.model.Artist;
import com.icc.reservations_springboot.service.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index(Model model) {
        List<Artist> artists = service.getAllArtists();

        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");

        return "artist/index";
    }

}

