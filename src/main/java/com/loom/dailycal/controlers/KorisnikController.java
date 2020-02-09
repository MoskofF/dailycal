package com.loom.dailycal.controlers;

import com.loom.dailycal.models.*;
import com.loom.dailycal.services.*;
import com.loom.dailycal.validator.KorisnikValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private InstruktorService instruktorService;

    @Autowired
    private ProgramaIshrService programaIshrService;

    @Autowired
    private ProgramaTreningService programaTreningService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private KorisnikValidator korisnikValidator;

    @Autowired
    private CelService celService;


    @RequestMapping("/getall")
    public String getAllKorisnik(Model model) {
        List<Korisnik> korisniks = korisnikService.getAllKorisnik();
        model.addAttribute("korisniks", korisniks);
        return "korisniks";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("korisnik", new Korisnik());

        List<FitnesInstruktor> instruktors = instruktorService.getAllInstruktor();
        model.addAttribute("instruktors", instruktors);

        List<ProgramaIshrana> programshrana = programaIshrService.getAllProgramaIshr();
        model.addAttribute("programashrana", programshrana);

        List<ProgramaTrening> programstrening = programaTreningService.getAllProgramaTrening();
        model.addAttribute("programastrening", programstrening);

        List<Cel> cels = celService.getAllCel();
        model.addAttribute("cels", cels);

        return "register";
    }

    @PostMapping("/register")
    public String addNew(@ModelAttribute Korisnik korisnik, BindingResult bindingResult) {
        korisnikValidator.validate(korisnik, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        korisnikService.save(korisnik);

        securityService.autoLogin(korisnik.getUsername(), korisnik.getPassword_conf());

        return "redirect:/index";
    }

}
