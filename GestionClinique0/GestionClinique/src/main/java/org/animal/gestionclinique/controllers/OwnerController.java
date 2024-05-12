package org.animal.gestionclinique.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Owner;
import org.animal.gestionclinique.services.OwnerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class OwnerController {
    private OwnerService ownerService;
    @RequestMapping("/createOwner")
    public String createOwner(ModelMap modelMap) {
        List<Owner> owners = ownerService.getAllProprietaires();
        modelMap.addAttribute("owners", owners);
        return "createOwner";
    }


    @RequestMapping("saveOwner")
    public String saveOwner(@Valid Owner owner, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "createOwner";
        Owner saveOwner=ownerService.saveProprietaire(owner);
        return "redirect:/createOwner";

    }
    @RequestMapping("/OwnersList")
    public String OwnersList(ModelMap modelMap,
                             @RequestParam(name="page",defaultValue = "0") int page,
                             @RequestParam(name="size",defaultValue = "3") int size

    ) {

        Page<Owner> owners=ownerService.getAllProprietairesByPage(page,size);
        modelMap.addAttribute("ownersVue",owners);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[owners.getTotalPages()]);
        return "OwnersList";
    }

    @RequestMapping("/deleteOwner")
    public String deleteOwner(@RequestParam("id") Long id,ModelMap modelMap,

                              @RequestParam(name="page",defaultValue = "0") int page,
                              @RequestParam(name="size",defaultValue = "3") int size) {
        ownerService.deleteProprietaireById(id);
        Page<Owner> owners=ownerService.getAllProprietairesByPage(page,size);
        modelMap.addAttribute("ownersVue",owners);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[owners.getTotalPages()]);
        return "OwnersList";}


    @RequestMapping("/editeOwner")
    public String editOwner(@RequestParam("id") Long id,ModelMap modelMap) {
        Owner owner= ownerService.getProprietaireById(id);
        modelMap.addAttribute("owner",owner);
        return "EditeOwner";
    }
    @RequestMapping("/updateOwner")
    public String updateOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.updateProprietaire(owner);
        return "redirect:/OwnersList";
    }



        @GetMapping("/search")
        public String searchOwners(@RequestParam("query") String query, ModelMap model) {
            List<Owner> owners = ownerService.searchOwners(query);
            model.addAttribute("owners", owners);
            return "search_results"; // Nom de votre page de résultats de recherche
        }
    }


