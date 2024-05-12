package org.animal.gestionclinique.controllers;

import lombok.AllArgsConstructor;
import org.animal.gestionclinique.entities.Animal;
import org.animal.gestionclinique.entities.Owner;
import org.animal.gestionclinique.services.OwnerService;
import org.animal.gestionclinique.services.PetService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor
public class AnimalController {
    private PetService petService;
    private OwnerService ownerService;
    @RequestMapping("/createPet")
    public String createPet(ModelMap model) {
        List<Owner> owners=ownerService.getAllProprietaires();
        model.addAttribute("ownersList",owners);
        return "createPet";
    }

    @RequestMapping("/savePet")
    public String savePet(Animal pet, BindingResult bindingResult, @RequestParam("ownerId") Long ownerId
                          ) {
        if (bindingResult.hasErrors()) {
            return "createPet";
        }

        Owner owner = ownerService.getProprietaireById(ownerId);
        pet.setOwner(owner);

        Animal savedPet = petService.saveAnimal(pet);

        return "redirect:/createPet";
    }



    @RequestMapping("/PetList")
    public String PetList(ModelMap modelMap,
                          @RequestParam(name="page",defaultValue = "0") int page,
                          @RequestParam(name="size",defaultValue = "3") int size) {
        Page<Animal> animals = petService.getAllAnimalsByPage(page,size);
        Page<Owner> owners = ownerService.getAllProprietairesByPage(page,size);

        modelMap.addAttribute("PetVue", animals);
        modelMap.addAttribute("ownersVue", owners);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[animals.getTotalPages()]);
        return "PetList";
    }


    @RequestMapping("/deletePet")
    public String deletePet(@RequestParam("id") Long id,ModelMap modelMap,
                            @RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name="size",defaultValue = "3") int size  ) {
        petService.deleteAnimalById(id);
        Page<Animal> animals = petService.getAllAnimalsByPage(page,size);
        modelMap.addAttribute("PetVue", animals);
        modelMap.addAttribute("currentPage",page);
        modelMap.addAttribute("pages",new int[animals.getTotalPages()]);
        return"PetList";
       }

       @RequestMapping("/editPet")
        public String editPet(@RequestParam("id") Long id,ModelMap modelMap) {
        List<Owner> owners = ownerService.getAllProprietaires();
        Animal animal=petService.getAnimalById(id);
        modelMap.addAttribute("petVue",animal);
        modelMap.addAttribute("owners", owners);
        return "EditPet";
       }

       @RequestMapping("/updatePet")
       public String updatePet(@ModelAttribute("PetVue") Animal animal, @RequestParam("ownerId") Long ownerId) {
           Owner owner = ownerService.getProprietaireById(ownerId);
           animal.setOwner(owner);
           petService.updateAnimal(animal);
           return "redirect:/PetList";

       }


}

