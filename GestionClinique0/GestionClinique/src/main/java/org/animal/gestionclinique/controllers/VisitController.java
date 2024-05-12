package org.animal.gestionclinique.controllers;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.*;
import org.animal.gestionclinique.services.*;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class VisitController {
    private VisitService visitService;
    private PetService petService;
    private VetService vetService;
    private PrescriptionService prescriptionService;
    private TypeService typeService;
    private RendezVService rendezVService;

    @RequestMapping("/createVisit")
    public String createVisit(ModelMap model) {
        List<Animal> animals = petService.getAllAnimals();
        List<Medecin> medecins = vetService.getAllMedecin();
        List<Prescription> prescriptions = prescriptionService.getAllPrescription();
        List<Type> types = typeService.getAllType();
        List<RendezV> rendezVS = rendezVService.getAllRendezVs();

        model.addAttribute("animals", animals);
        model.addAttribute("medecins", medecins);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("types", types);
        model.addAttribute("rendezVS", rendezVS);

        return "createVisit";
    }

    @RequestMapping("/saveVisit")
    public String saveVisit(@ModelAttribute("visit") Visit visit, BindingResult bindingResult, @RequestParam("animalId") Long animalId,
                            @RequestParam("medecinId") Long medecinId, @RequestParam("newPrescription") String newPrescription,
                            @RequestParam("newType") String newType, @RequestParam("dateRDV") LocalDate dateRDV,
                            @RequestParam(value = "rendezVId", required = false) Long rendezVId) {
        if (bindingResult.hasErrors()) {
            return "createVisit";
        }

        Animal animal = petService.getAnimalById(animalId);
        Medecin medecin = vetService.getMedecinById(medecinId);

        visit.setAnimal(animal);
        visit.setMedecin(medecin);

        RendezV rendezV;
        if (rendezVId != null) {
            rendezV = rendezVService.getRendezVById(rendezVId);
        } else {
            rendezV = rendezVService.getRendezVByDate(dateRDV);
            if (rendezV == null) {
                rendezV = new RendezV();
                rendezV.setDateRDV(dateRDV);
                rendezVService.saveRendezV(rendezV);
            }
        }
        visit.setRendezV(rendezV);

        if (!newPrescription.isEmpty()) {
            Prescription newPrescriptionObj = new Prescription();
            newPrescriptionObj.setName(newPrescription);
            prescriptionService.savePrescription(newPrescriptionObj);
            visit.setPrescription(newPrescriptionObj);
        }

        if (!newType.isEmpty()) {
            Type newTypeObj = new Type();
            newTypeObj.setName(newType);
            typeService.saveType(newTypeObj);
            visit.setType(newTypeObj);
        }

        visitService.saveVisit(visit);

        return "redirect:/createVisit";
    }


    @RequestMapping("/visitList")
    public String visitList(ModelMap modelMap,
                            @RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<Visit> visits = visitService.getAllVisitByPage(page, size);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[visits.getTotalPages()]);
        modelMap.addAttribute("visitVue", visits);
        return "visitList";
    }

    @RequestMapping("/deleteVisit")
    public String deleteVisit(@RequestParam("id") Long id, ModelMap modelMap,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "3") int size) {
        visitService.deleteVisit(id);
        Page<Visit> visits = visitService.getAllVisitByPage(page, size);
        modelMap.addAttribute("VetVue", visits);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[visits.getTotalPages()]);
        modelMap.addAttribute("visitVue", visits);
        return "visitList";
    }


    @GetMapping("/editVisit")
    public String editVisit(@RequestParam("id") Long id, ModelMap model) {
        Visit visit = visitService.getVisitById(id);
        if (visit == null) {
            return "error";
        }

        List<Animal> animals = petService.getAllAnimals();
        List<Medecin> medecins = vetService.getAllMedecin();
        List<Prescription> prescriptions = prescriptionService.getAllPrescription();
        List<Type> types = typeService.getAllType();
        RendezV rendezV = visit.getRendezV();

        model.addAttribute("visit", visit);
        model.addAttribute("animals", animals);
        model.addAttribute("medecins", medecins);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("types", types);
        model.addAttribute("rendezV", rendezV);

        return "editVisit";
    }


    @PostMapping("/updateVisit")
    public String updateVisit(@ModelAttribute("visit") Visit visit, BindingResult bindingResult,
                              @RequestParam("animalId") Long animalId,
                              @RequestParam("medecinId") Long medecinId,
                              @RequestParam("newPrescription") String newPrescription,
                              @RequestParam("newType") String newType,
                              @RequestParam("dateRDV") String dateRDV,
                              @RequestParam(value = "rendezVId", required = false) Long rendezVId) {
        if (bindingResult.hasErrors()) {
            return "editVisit";
        }

        if (animalId == null || medecinId == null) {
            return "error";
        }

        Animal animal = petService.getAnimalById(animalId);
        Medecin medecin = vetService.getMedecinById(medecinId);

        visit.setAnimal(animal);
        visit.setMedecin(medecin);

        RendezV rendezV;
        if (rendezVId != null) {
            rendezV = rendezVService.getRendezVById(rendezVId);
        } else {
            LocalDate parsedDateRDV = LocalDate.parse(dateRDV);
            rendezV = new RendezV();
            rendezV.setDateRDV(parsedDateRDV);
            rendezVService.saveRendezV(rendezV);
        }
        visit.setRendezV(rendezV);

        if (!newPrescription.isEmpty()) {
            Prescription newPrescriptionObj = new Prescription();
            newPrescriptionObj.setName(newPrescription);
            prescriptionService.savePrescription(newPrescriptionObj);
            visit.setPrescription(newPrescriptionObj);
        }

        if (!newType.isEmpty()) {
            Type newTypeObj = new Type();
            newTypeObj.setName(newType);
            typeService.saveType(newTypeObj);
            visit.setType(newTypeObj);
        }

        visitService.saveVisit(visit);

        return "redirect:/visitList";
    }

}
