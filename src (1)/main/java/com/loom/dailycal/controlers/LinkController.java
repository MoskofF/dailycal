package com.loom.dailycal.controlers;

import com.loom.dailycal.models.*;
import com.loom.dailycal.models.wrapers.ObrokShWrap;
import com.loom.dailycal.models.wrapers.TreningStWrap;
import com.loom.dailycal.models.wrapers.obrok_hrana;
import com.loom.dailycal.relations.ObrokShKey;
import com.loom.dailycal.relations.ObrokSpKey;
import com.loom.dailycal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @Autowired
    private TreningService treningService;

    @Autowired
    private DnevnikTreningService dnevnikTreningService;

    @Autowired
    private VezhbaService vezhbaService;

    @Autowired
    private TreningSvService treningSvService;

    @Autowired
    private DnevnikTrchanjeService dnevnikTrchanjeService;

    @Autowired
    private SportService sportService;

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
        modelAndView.setViewName("kreiraj_obrok");

        modelAndView.addObject("wrap", new ObrokShWrap());

        List<Hrana> hrani = hranaService.getAllHrana();
        modelAndView.addObject("hrani", hrani);

        List<Pialok> pialoci = pialokService.getAllPialok();
        modelAndView.addObject("pialoci", pialoci);


        return modelAndView;
    }

    @PostMapping("/kreiraj_obrok")
    public ModelAndView createObrok(@ModelAttribute ObrokShWrap obrokShWrap, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("kreiraj_obrok");
        }

        Obrok obrok = new Obrok();
        obrok.setOpis_obrok(obrokShWrap.getOpis_obrok());
        obrokService.addObrok(obrok);

        for (int i = 0; i < 5; i++) {
            if (obrokShWrap.getHranas().get(i).getHrana() != 0 && obrokShWrap.getHranas().get(i).getKolichina() != 0) {
                ObrokSh obrokSh = new ObrokSh();
                obrokSh.setObrok(obrok);
                obrokSh.setHrana(hranaService.getHranaId(obrokShWrap.getHranas().get(i).getHrana()));
                obrokSh.setKolichina(obrokShWrap.getHranas().get(i).getKolichina());
                obrokSh.setId(new ObrokShKey(obrokShWrap.getHranas().get(i).getHrana(), obrokShWrap.getHranas().get(i).getKolichina()));

                obrokShService.addHranaToObrok(obrokSh);
            } else {
                break;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (obrokShWrap.getPialoks().get(i).getPialok() != 0 && obrokShWrap.getPialoks().get(i).getKolichina() != 0) {
                ObrokSp obrokSp = new ObrokSp();
                obrokSp.setObrok(obrok);
                obrokSp.setPialok(pialokService.getPialokId(obrokShWrap.getPialoks().get(i).getPialok()));
                obrokSp.setKolichina(obrokShWrap.getPialoks().get(i).getKolichina());
                obrokSp.setId(new ObrokSpKey(obrokShWrap.getPialoks().get(i).getPialok(), obrokShWrap.getPialoks().get(i).getKolichina()));

                obrokSpService.addPialokToObrok(obrokSp);
            } else {
                break;
            }
        }


        return this.redirect("dodaj_obrok");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return this.redirect("index");
    }

    @GetMapping("/dodaj_hrana")
    public ModelAndView dodajHrana(ModelAndView modelAndView) {
        modelAndView.setViewName("dodaj_hrana");

        modelAndView.addObject("hrana", new Hrana());

        return modelAndView;
    }

    @PostMapping("/dodaj_hrana")
    public ModelAndView addHrana(@ModelAttribute Hrana hrana, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.view("dodaj_hrana");
        }

        if (hrana != null) {
            hranaService.addHrana(hrana);
        } else {
            System.out.println("Gresha pri hrana");
        }

        return this.redirect("index");
    }

    @GetMapping("/dodaj_pialok")
    public ModelAndView dodajPialok(ModelAndView modelAndView) {
        modelAndView.setViewName("dodaj_pialok");

        modelAndView.addObject("pialok", new Pialok());

        return modelAndView;
    }

    @PostMapping("/dodaj_pialok")
    public ModelAndView addPialok(@ModelAttribute Pialok pialok, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.view("dodaj_pialok");
        }

        if (pialok != null) {
            pialokService.addPialok(pialok);
        } else {
            System.out.println("Gresha pri pialok");
        }

        return this.redirect("index");
    }

    @GetMapping("/dodaj_sport")
    public ModelAndView dodajSport(ModelAndView modelAndView) {
        modelAndView.setViewName("dodaj_sport");

        modelAndView.addObject("sport", new Sport());

        return modelAndView;
    }

    @PostMapping("/dodaj_sport")
    public ModelAndView addSport(@ModelAttribute Sport sport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.view("dodaj_sport");
        }

        if (sport != null) {
            sportService.addSport(sport);
        } else {
            System.out.println("Gresha pri sport");
        }

        return this.redirect("index");
    }

    @GetMapping("/dodaj_vezhba")
    public ModelAndView dodajVezhba(ModelAndView modelAndView) {
        modelAndView.setViewName("dodaj_vezhba");

        modelAndView.addObject("vezhba", new Vezhba());

        return modelAndView;
    }

    @PostMapping("/dodaj_vezhba")
    public ModelAndView addSport(@ModelAttribute Vezhba vezhba, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.view("dodaj_vezhba");
        }

        if (vezhba != null) {
            vezhbaService.addVezhba(vezhba);
        } else {
            System.out.println("Gresha pri vezhba");
        }

        return this.redirect("index");
    }

    @GetMapping("/dodaj_trening")
    public ModelAndView dodajTrening(ModelAndView modelAndView) {

        modelAndView.setViewName("dodaj_trening");

        modelAndView.addObject("dnevnikTrening", new DnevnikTrening());

        List<Trening> treninzi = treningService.getAllTrening();
        modelAndView.addObject("treninzi", treninzi);

        return modelAndView;
    }

    @PostMapping("/dodaj_trening")
    public ModelAndView addTrening(@ModelAttribute DnevnikTrening dnevnikTrening, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("dodaj_trening");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik korisnik = korisnikService.findByUsername(un);

        dnevnikTrening.setKorisnik(korisnik);

        dnevnikTreningService.addDnevnik(dnevnikTrening);

        return this.redirect("index");
    }

    @GetMapping("/kreiraj_trening")
    public ModelAndView createTrening(ModelAndView modelAndView) {
        modelAndView.setViewName("kreiraj_trening");

        modelAndView.addObject("wrap", new TreningStWrap());

        List<Sport> sportovi = sportService.getAllSport();
        modelAndView.addObject("sportovi", sportovi);

        List<Vezhba> vezhbi = vezhbaService.getAllVezhba();
        modelAndView.addObject("vezhbi", vezhbi);

        return modelAndView;
    }

    @PostMapping("/kreiraj_trening")
    public ModelAndView kreirajTrening(@ModelAttribute TreningStWrap treningStWrap, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("kreiraj_trening");
        }

        Trening trening = new Trening();
        trening.setOpis_treining(treningStWrap.getOpis_trening());
        if (treningStWrap.getSport() != -1)
        trening.setSport(sportService.getSportId(treningStWrap.getSport()));
        treningService.addTrening(trening);

        for (int i = 0; i < 15; i++) {
            if (treningStWrap.getVezhbas().get(i).getVezhba() != 0 && treningStWrap.getVezhbas().get(i).getPovtoruvanja() != 0) {
                TreningSv treningSv = new TreningSv();
                treningSv.setTrening(trening);
                treningSv.setVezhba(vezhbaService.getVezhbaId(treningStWrap.getVezhbas().get(i).getVezhba()));
                treningSv.setPovtoruvanja(treningStWrap.getVezhbas().get(i).getPovtoruvanja());

                treningSvService.addVezhbaToTrening(treningSv);
            } else {
                break;
            }
        }


        return this.redirect("dodaj_trening");
    }

    @GetMapping("/dodaj_trchanje")
    public ModelAndView dodajTchanje(ModelAndView modelAndView) {
        modelAndView.setViewName("dodaj_trchanje");

        modelAndView.addObject("dnevnikTrchanje" , new DnevnikRun());

        return modelAndView;
    }

    @PostMapping("/dodaj_trchanje")
    public ModelAndView addTrchanje(@ModelAttribute DnevnikRun dnevnikTrchanje, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return this.view("dodaj_trchanje");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String un = auth.getName();

        Korisnik korisnik = korisnikService.findByUsername(un);

        dnevnikTrchanje.setKorisnik(korisnik);

        dnevnikTrchanjeService.addDnevnik(dnevnikTrchanje);

        return this.redirect("index");
    }



}
