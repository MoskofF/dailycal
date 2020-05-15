package com.loom.dailycal.controlers;

import com.loom.dailycal.models.*;
import com.loom.dailycal.querys.*;
import com.loom.dailycal.services.*;
import com.loom.dailycal.validator.KorisnikValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController extends BaseController {

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

    @Autowired
    private KaloriiService kaloriiService;

    @Autowired
    private MetriService metriService;


    @RequestMapping("/getall")
    public ModelAndView getAllKorisnik(ModelAndView modelAndView) {

        modelAndView.setViewName("korisniks");
        List<Korisnik> korisniks = korisnikService.getAllKorisnik();
        modelAndView.addObject("korisniks", korisniks);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.setViewName("register");

        modelAndView.addObject("korisnik", new Korisnik());

        List<FitnesInstruktor> instruktors = instruktorService.getAllInstruktor();
        modelAndView.addObject("instruktors", instruktors);

        List<ProgramaIshrana> programshrana = programaIshrService.getAllProgramaIshr();
        modelAndView.addObject("programashrana", programshrana);

        List<ProgramaTrening> programstrening = programaTreningService.getAllProgramaTrening();
        modelAndView.addObject("programastrening", programstrening);

        List<Cel> cels = celService.getAllCel();
        modelAndView.addObject("cels", cels);

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView addNew(@ModelAttribute Korisnik korisnik, BindingResult bindingResult) {
        korisnikValidator.validate(korisnik, bindingResult);

        if (bindingResult.hasErrors()) {
            return this.view("register");
        }

        korisnikService.save(korisnik);

        securityService.autoLogin(korisnik.getUsername(), korisnik.getPassword_conf());

        return this.redirect("../index");
    }

    @GetMapping("/profil")
    public ModelAndView profil(ModelAndView modelAndView) {

        modelAndView.setViewName("profil");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik korisnik = korisnikService.findByUsername(un);

        modelAndView.addObject("korisnik", korisnik);

        List<Cel> celi = celService.getAllCel();
        modelAndView.addObject("celi", celi);

        List<FitnesInstruktor> instruktori = instruktorService.getAllInstruktor();
        modelAndView.addObject("instruktori", instruktori);

        List<ProgramaIshrana> ishrana = programaIshrService.getAllProgramaIshr();
        modelAndView.addObject("ishrani", ishrana);

        List<ProgramaTrening> trening = programaTreningService.getAllProgramaTrening();
        modelAndView.addObject("treninzi", trening);

        return modelAndView;
    }

    @PostMapping("/profil")
    public ModelAndView updateProfil(@ModelAttribute Korisnik korisnik, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.view("profil");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik k = korisnikService.findByUsername(un);


        korisnikService.updateKorisnik(k.getUser_id(), korisnik);

        return this.view("profil");
    }

    @GetMapping("/statistica")
    public ModelAndView statistika(ModelAndView modelAndView) {
        modelAndView.setViewName("statistica");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik k = korisnikService.findByUsername(un);

        KaloriiNedelno kaloriiNedelno = kaloriiService.getNedelniKaloriiKorisnik(k.getUser_id());
        KaloriiMesecno kaloriiMesecno = kaloriiService.getMesecniKaloriiKorisnik(k.getUser_id());
        KaloriiTriMesecno kaloriiTriMesecno = kaloriiService.getTriMesecniKaloriiKorisnik(k.getUser_id());

        modelAndView.addObject("kaloriiNedelno", kaloriiNedelno);
        modelAndView.addObject("kaloriiMesecno", kaloriiMesecno);
        modelAndView.addObject("kaloriiTriMesecno", kaloriiTriMesecno);

        MetriNedelno metriNedelno = metriService.getMetriNedelnoKorisnik(k.getUser_id());
        MetriMesecno metriMesecno = metriService.getMetriMesecnoKorisnik(k.getUser_id());
        MetriTriMesecno metriTriMesecno = metriService.getMetriTriMesecnoKorisnik(k.getUser_id());

        modelAndView.addObject("metriNedelno", metriNedelno);
        modelAndView.addObject("metriMesecno", metriMesecno);
        modelAndView.addObject("metriTriMesecno", metriTriMesecno);

        return modelAndView;
    }

}
