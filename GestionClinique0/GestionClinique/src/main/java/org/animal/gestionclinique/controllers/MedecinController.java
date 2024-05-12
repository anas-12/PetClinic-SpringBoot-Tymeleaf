package org.animal.gestionclinique.controllers;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Clinique;
import org.animal.gestionclinique.entities.Medecin;
import org.animal.gestionclinique.services.CliniqueService;
import org.animal.gestionclinique.services.VetService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MedecinController {
    private VetService vetService;
    private CliniqueService cliniqueService;
    @RequestMapping("/CreateVet")
    public String createVet(Model modelMap) {
        List<Medecin> vets = vetService.getAllMedecin();
        modelMap.addAttribute("vets", vets);
        List<Clinique> clinics = cliniqueService.getAllClinique();
        modelMap.addAttribute("clinics", clinics);
        return "CreateVet";
    }

    @RequestMapping("saveVet")
    public String saveVet(Medecin medecin, @RequestParam("clinicId") Long clinicId, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "CreateVet";

        Clinique clinique = cliniqueService.getCliniqueById(clinicId);
        medecin.setClinique(clinique);

        Medecin savedVet = vetService.saveMedecin(medecin);
        return "redirect:/CreateVet";
    }

    @RequestMapping("/VetList")
    public String OwnersVet(ModelMap modelMap,
                             @RequestParam(name="page",defaultValue = "0") int page,
                             @RequestParam(name="size",defaultValue = "3") int size

    ) {

        Page<Medecin> vets=vetService.getAllProprietairesByPage(page,size);
        modelMap.addAttribute("VetVue",vets);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[vets.getTotalPages()]);
        return "VetList";
    }

    @RequestMapping("/deleteVet")
    public String deleteVet(@RequestParam("id") Long id,ModelMap modelMap,
                              @RequestParam(name="page",defaultValue = "0") int page,
                              @RequestParam(name="size",defaultValue = "3") int size) {
        vetService.deleteMedecin(id);
        Page<Medecin> vets=vetService.getAllProprietairesByPage(page,size);
        modelMap.addAttribute("VetVue",vets);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[vets.getTotalPages()]);
        return "VetList";}


    @RequestMapping("/editeVet")
    public String editVet(@RequestParam("id") Long id, ModelMap modelMap) {
        Medecin medecin = vetService.getMedecinById(id);
        List<Clinique> clinics = cliniqueService.getAllClinique();
        modelMap.addAttribute("vet", medecin);
        modelMap.addAttribute("cliniques", clinics);
        return "EditeVet";
    }
    @RequestMapping("/updateVet")
    public String updateVet(@ModelAttribute("vet") Medecin medecin , @RequestParam("cliniqueId") Long cliniqueId) {
        vetService.updateMedecin(medecin);
        Clinique clinic = cliniqueService.getCliniqueById(cliniqueId);
        medecin.setClinique(clinic);
        vetService.updateMedecin(medecin);

        return "redirect:/VetList";
    }

}
