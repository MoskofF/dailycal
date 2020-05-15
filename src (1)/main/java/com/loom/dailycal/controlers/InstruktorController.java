package com.loom.dailycal.controlers;

import com.loom.dailycal.models.FitnesInstruktor;
import com.loom.dailycal.models.Korisnik;
import com.loom.dailycal.services.InstruktorService;
import com.loom.dailycal.services.SecurityService;
import com.loom.dailycal.validator.KorisnikValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instruktori")
public class InstruktorController extends BaseController {

    @Autowired
    private InstruktorService instruktorService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private KorisnikValidator korisnikValidator;

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("register_inst");
        modelAndView.addObject("instruktor", new FitnesInstruktor());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView addNew(@ModelAttribute FitnesInstruktor instruktor, BindingResult bindingResult) {
        korisnikValidator.validate(instruktor, bindingResult);

        if (bindingResult.hasErrors()) {
            return this.view("register_inst");
        }

        instruktorService.addInstruktor(instruktor);

        securityService.autoLogin(instruktor.getUsername(), instruktor.getPassword_conf());

        return this.redirect("../index");
    }
}
