package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    // Add private field of SkillRepository type called skillRepository
    @Autowired
    private SkillRepository skillRepository;

    // responds at /skills with a list of all skills in the database
    @GetMapping("/")
    public String index(Model model) {
        //pass skills to the "view" using model.addAttribute to display list of all employers using findAll()
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    // Displays the form to add a new skill
    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        // changed routing to /skills/add
        return "skills/add";
    }

    // Processes the form to add a new skill
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {
        // Check if there are any validation errors
        if (errors.hasErrors()) {
            return "skills/add";
        }
        // Save the new Skill object to the repository
        skillRepository.save(newSkill);
        return "redirect:";
    }

    // displays details for a specific skill
    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        // Retrieve the skill by its ID from the repository
        Optional<Skill> optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}

