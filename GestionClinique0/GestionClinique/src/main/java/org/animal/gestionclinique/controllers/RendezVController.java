package org.animal.gestionclinique.controllers;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.RendezV;
import org.animal.gestionclinique.services.RendezVService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class RendezVController {

    private RendezVService rendezVService;

    @RequestMapping("/createRendezV")
    public String createRendezV() {
        return "createRendezV";
    }

    @RequestMapping("/saveRendezV")
    public String saveRendezV(@ModelAttribute RendezV rendezV) {
        rendezVService.saveRendezV(rendezV);
        return "redirect:/RendezVsList";
    }

    @RequestMapping("/RendezVsList")
    public String rendezVsList(ModelMap modelMap,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "3") int size) {

        Page<RendezV> rendezVs = rendezVService.getAllRendezVsByPage(page, size);
        modelMap.addAttribute("rendezVsVue", rendezVs);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[rendezVs.getTotalPages()]);
        return "RendezVsList";
    }

    @RequestMapping("/deleteRendezV")
    public String deleteRendezV(@RequestParam("id") Long id, ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "3") int size) {
        rendezVService.deleteRendezVById(id);
        Page<RendezV> rendezVs = rendezVService.getAllRendezVsByPage(page, size);
        modelMap.addAttribute("rendezVsVue", rendezVs);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[rendezVs.getTotalPages()]);
        return "RendezVsList";
    }

    @RequestMapping("/editRendezV")
    public String editRendezV(@RequestParam("id") Long id, ModelMap modelMap) {
        RendezV rendezV = rendezVService.getRendezVById(id);
        modelMap.addAttribute("rendezV", rendezV);
        return "editRendezV";
    }

    @RequestMapping("/updateRendezV")
    public String updateRendezV(@ModelAttribute RendezV rendezV) {
        rendezVService.updateRendezV(rendezV);
        return "redirect:/RendezVsList";
    }
}
