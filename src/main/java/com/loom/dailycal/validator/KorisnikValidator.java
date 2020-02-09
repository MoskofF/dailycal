package com.loom.dailycal.validator;

import com.loom.dailycal.models.FitnesInstruktor;
import com.loom.dailycal.models.Korisnik;
import com.loom.dailycal.services.InstruktorService;
import com.loom.dailycal.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class KorisnikValidator implements Validator {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private InstruktorService instruktorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Korisnik.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (target instanceof Korisnik) {
            Korisnik korisnik = (Korisnik) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

            if (korisnik.getUsername().length() < 6 || korisnik.getUsername().length() > 32) {
                errors.rejectValue("username", "Size.userForm.username");
            }

            if (korisnikService.findByUsername(korisnik.getUsername()) != null) {
                errors.rejectValue("username", "Duplicate.userForm.username");
            }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (korisnik.getPassword().length() < 8 || korisnik.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.userForm.password");
            }

            if (!korisnik.getPassword_conf().equals(korisnik.getPassword())) {
                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            }
        } else {
            FitnesInstruktor instruktor = (FitnesInstruktor) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

            if (instruktor.getUsername().length() < 6 || instruktor.getUsername().length() > 32) {
                errors.rejectValue("username", "Size.userForm.username");
            }

            if (instruktorService.findByUsername(instruktor.getUsername()) != null) {
                errors.rejectValue("username", "Duplicate.userForm.username");
            }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (instruktor.getPassword().length() < 8 || instruktor.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.userForm.password");
            }

            if (!instruktor.getPassword_conf().equals(instruktor.getPassword())) {
                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            }
        }
    }
}
