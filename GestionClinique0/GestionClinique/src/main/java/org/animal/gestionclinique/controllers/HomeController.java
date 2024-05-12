package org.animal.gestionclinique.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    @GetMapping("/index.html")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/CreateClinique.html")
    public String CreateCliniquePage() {
        return "CreateClinique";
    }
    @GetMapping("/CreateVet.html")
    public String CreateDoctorPage() {
        return "CreateVet";
    }

    @GetMapping("/CreateOwner.html")
    public String CreateOwnerPage() {
        return "createOwner";
    }
    @GetMapping("/createPet.html")
    public String PetPage() {
        return "createPet";
    }
    @GetMapping("/CliniqueList.html")
    public String CliniqueListPage() {
        return "CliniqueList.html";
    }

}
