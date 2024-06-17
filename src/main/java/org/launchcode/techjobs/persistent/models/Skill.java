package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    // Add description field
    private String description;

    //add jobs field as a List type
    //use @ManyToMany annotation with an argument mappedBy="skills"
    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    //no-arg constructor
    public Skill() {
    }

    //public accessor methods w/ getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //getter and setter for jobs
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}

