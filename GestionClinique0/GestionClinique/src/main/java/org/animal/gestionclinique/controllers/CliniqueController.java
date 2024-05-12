package org.animal.gestionclinique.controllers;
import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Clinique;
import org.animal.gestionclinique.services.CliniqueService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class CliniqueController {
    private final CliniqueService cliniqueService;

    @GetMapping("/cliniqueList")
    public String listCliniques(ModelMap modelMap,
                                @RequestParam(name="page",defaultValue = "0") int page,
                                @RequestParam(name="size",defaultValue = "3") int size) {
        Page<Clinique> cliniques = cliniqueService.getAllCliniquesByPage(page,size);
        modelMap.addAttribute("cliniques", cliniques);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[cliniques.getTotalPages()]);
        modelMap.addAttribute("visitVue", cliniques);

        return "cliniqueList";
    }

    @GetMapping("/createClinique")
    public String showAddCliniqueForm(Model model) {
        model.addAttribute("clinique", new Clinique());
        return "createClinique";
    }

    @PostMapping("/saveClinique")
    public String addClinique(@ModelAttribute("clinique") Clinique clinique) {
        cliniqueService.saveClinique(clinique);
        return "createClinique";
    }

    @RequestMapping("/deleteClinique")
    public String deleteClinique(@RequestParam("id") Long id,ModelMap modelMap,
                                 @RequestParam(name="page",defaultValue = "0") int page,
                                 @RequestParam(name="size",defaultValue = "3") int size) {
        cliniqueService.deleteCliniqueById(id);
        Page<Clinique> cliniques = cliniqueService.getAllCliniquesByPage(page,size);
        modelMap.addAttribute("cliniques", cliniques);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[cliniques.getTotalPages()]);
        modelMap.addAttribute("visitVue", cliniques);


        return "cliniqueList";
    }

}
