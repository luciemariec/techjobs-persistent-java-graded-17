package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    //give employerRepository @Autowired annotation
    @Autowired
    //Add private field of EmployerRepository type called employerRepository
    private EmployerRepository employerRepository;

    //responds at /employers  with a list of all employers in the database
    @GetMapping("/")
    public String index(Model model) {
        //pass employers to the "view" using model.addAttribute to display list of all employers using findAll()
        model.addAttribute("employer", employerRepository.findAll());
        //use template employer/index
        return "employers/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("employer", new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }
        // add method to save valid employer object using newEmployer object
        employerRepository.save(newEmployer);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        //replace the null value in optEmployer using the findById method passing in
        //employerId to find a specific employer object in the database
        Optional<Employer> optEmployer =  employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
