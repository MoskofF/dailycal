package com.loom.dailycal.controlers;

import com.loom.dailycal.models.*;
import com.loom.dailycal.relations.ObrokShKey;
import com.loom.dailycal.relations.ObrokSpKey;
import com.loom.dailycal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class LinkController extends BaseController {

    @Autowired
    private ObrokService obrokService;

    @Autowired
    private DnevnikIshranaService dnevnikIshranaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private ObrokShService obrokShService;

    @Autowired
    private ObrokSpService obrokSpService;

    @Autowired
    private HranaService hranaService;

    @Autowired
    private PialokService pialokService;

    @GetMapping("/dodaj_obrok")
    public ModelAndView dodajObrok(ModelAndView modelAndView) {

        modelAndView.setViewName("dodaj_obrok");

        modelAndView.addObject("dnevnikIshrana", new DnevnikIshrana());

        List<Obrok> obroci = obrokService.getAllObrok();
        modelAndView.addObject("obroci", obroci);

        return modelAndView;
    }

    @PostMapping("/dodaj_obrok")
    public ModelAndView addObrok(@ModelAttribute DnevnikIshrana dnevnikIshrana, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("dodaj_obrok");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik korisnik = korisnikService.findByUsername(un);

        dnevnikIshrana.setKorisnik(korisnik);

        dnevnikIshranaService.addDnevnik(dnevnikIshrana);

        return this.redirect("index");
    }

    @GetMapping("/kreiraj_obrok")
    public ModelAndView kreirajObrok(ModelAndView modelAndView) {

        modelAndView.addObject("obrok", new Obrok());


        return modelAndView;
    }

    @PostMapping("/kreiraj_obrok")
    public ModelAndView createObrok(@ModelAttribute Obrok obrok, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("kreiraj_obrok");
        }

        obrokService.addObrok(obrok);

        ModelAndView modelAndView = new ModelAndView("obrok_set_hrana");
        //modelAndView.addObject("obrok", obrok);

        ObrokSh obrokSh = new ObrokSh();
        obrokSh.setObrok(obrok);

        ObrokSp obrokSp = new ObrokSp();
        obrokSp.setObrok(obrok);

        modelAndView.addObject("obrokSh", obrokSh);
        modelAndView.addObject("obrokSp", obrokSp);

        List<Hrana> hrani = hranaService.getAllHrana();
        modelAndView.addObject("hrani", hrani);

        List<Pialok> pialoci = pialokService.getAllPialok();
        modelAndView.addObject("pialoci", pialoci);

        return modelAndView;
    }

    @GetMapping("/obrok_set_hrana")
    public /*@ResponseBody*/ ModelAndView obrokSetHrana(@ModelAttribute Obrok obrok,ModelAndView modelAndView) {

        ObrokSh obrokSh = new ObrokSh();
        obrokSh.setObrok(obrok);

        ObrokSp obrokSp = new ObrokSp();
        obrokSp.setObrok(obrok);

        modelAndView.addObject("obrokSh", obrokSh);
        modelAndView.addObject("obrokSp", obrokSp);

        List<Hrana> hrani = hranaService.getAllHrana();
        modelAndView.addObject("hrani", hrani);

        List<Pialok> pialoci = pialokService.getAllPialok();
        modelAndView.addObject("pialoci", pialoci);

        //modelAndView.addObject("id", obrok.getObrok_id());

        return modelAndView;
    }

    @PostMapping("/obrok_set_hrana")
    public ModelAndView obrokHrana(@ModelAttribute Obrok obrok, @ModelAttribute ObrokSh obrokSh,
                             @ModelAttribute ObrokSp obrokSp, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("obrok_set_hrana");
        modelAndView.addObject("obrok", obrok);

        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        //obrokSh.setObrok(obrok);
        obrokSh.setId(new ObrokShKey(obrokSh.getObrok().getObrok_id(), obrokSh.getHrana().getHrana_id()));
        obrokShService.addHranaToObrok(obrokSh);
        //obrokSp.setObrok(obrok);
        obrokSp.setId(new ObrokSpKey(obrokSp.getObrok().getObrok_id(), obrokSp.getPialok().getPialok_id()));
        obrokSpService.addPialokToObrok(obrokSp);

        return modelAndView;
    }
}
