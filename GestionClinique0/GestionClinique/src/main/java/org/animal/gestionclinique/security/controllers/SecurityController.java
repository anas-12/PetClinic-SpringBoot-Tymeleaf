package org.animal.gestionclinique.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "/AccessDenied";
    }
}
