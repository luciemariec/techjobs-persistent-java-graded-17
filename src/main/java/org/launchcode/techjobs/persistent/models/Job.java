package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;


@Entity
//Update the class definition of Job to extend AbstractEntity
public class Job extends AbstractEntity {

    //replace the type of the field employer to be of type Employer
    //add @ManyToOne annotation to the updated field Employer
    @ManyToOne
    private Employer employer;

    //refactored to be list of Skill objects
    @ManyToMany
    private List<Skill> skills;

    public Job() {
    }

    //refactor methods impacted from type change
    public Job(Employer employer, List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}

