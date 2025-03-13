package com.example.fotowettbewerb.controllers;

import com.example.fotowettbewerb.Fotos;
import com.example.fotowettbewerb.repositories.FotosRepository;
import com.example.fotowettbewerb.repositories.SterneRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class FotosController {

    private final FotosRepository fotosRepository;
    private final SterneRepository sterneRepository;

    public FotosController(FotosRepository fotosRepository, SterneRepository sterneRepository) {
        this.fotosRepository = fotosRepository;
        this.sterneRepository = sterneRepository;
    }

    @GetMapping("/fotos")
    public String alleFotosAnzeigen(Model model) {
        List<Fotos> fotos = fotosRepository.findAll();
        Map<Long, Integer> sterneMap = new HashMap<>();


        for (Fotos foto : fotos) {
            int anzahlSterne = sterneRepository.countByFotoId(foto.getId());
            sterneMap.put(foto.getId(), anzahlSterne);
        }

        model.addAttribute("sterneMap", sterneMap);
        model.addAttribute("fotos", fotos);
        return "fotos";
    }

}
