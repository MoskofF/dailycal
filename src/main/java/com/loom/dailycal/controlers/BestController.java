package com.loom.dailycal.controlers;


import com.loom.dailycal.models.ObrokSh;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BestController extends BaseController {



    @RequestMapping(value = "/proba")
    public ModelAndView proba(@ModelAttribute ObrokSh obrokSh) {
        //System.out.println(obrokSh);
        return this.view("kreiraj_obrok");
    }
}
