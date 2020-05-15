package com.loom.dailycal.controlers;

import com.loom.dailycal.models.FitnesInstruktor;
import com.loom.dailycal.models.Korisnik;
import com.loom.dailycal.services.InstruktorService;
import com.loom.dailycal.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController extends BaseController{

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private InstruktorService instruktorService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        if (korisnikService.findByUsername(un) != null) {
            Korisnik korisnik = korisnikService.findByUsername(un);
            return this.view("index");
        } else {
            FitnesInstruktor instruktor = instruktorService.findByUsername(un);
            return this.view("homeinst");
        }

    }

    @RequestMapping(value = "/")
    public ModelAndView home() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        if (korisnikService.findByUsername(un) != null) {
            Korisnik korisnik = korisnikService.findByUsername(un);
            return this.view("index");
        } else {
            FitnesInstruktor instruktor = instruktorService.findByUsername(un);
            return this.view("homeinst");
        }

    }


    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, String error, String logout) {

        modelAndView.setViewName("login");

        if (error != null) {
            modelAndView.addObject("error", "Your username or password is invalid.");
        }

        if (logout != null) {
            modelAndView.addObject("message", "Youhave been loged out successfully.");
        }

        return modelAndView;
    }

}
