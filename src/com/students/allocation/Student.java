package com.students.allocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private Long CNP;
    private String name;
    private int yearOfStudy;
    private List<Project> preferredProjects;
    private Project assignedProjects;

    public Student(Long CNP, String name, int yearOfStudy) {
        this.CNP = CNP;
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.preferredProjects = new ArrayList<>();
        this.assignedProjects = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void addProject(Project app) {
        this.preferredProjects.add(app);
    }

    public Project getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(Project assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

    public List<Project> getPreferredProjects() {
        return preferredProjects;
    }


    public Long getCNP() {
        return CNP;
    }

    @Override
    public String toString() {
        String result = "sunt " + name + " si imi plac urmatoarele proiecte: ";
        for (int i = 0; i < preferredProjects.size(); i++) {
            Project project = preferredProjects.get(i);
            result = result + project.getName();
            if (i < preferredProjects.size() - 1) {
                result = result + ", ";
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { // daca e aceeasi zona de memorie totul e ok si iese
            return true;
        }
        if (o == null || getClass() != o.getClass()) { //daca sunt obiecte diferite
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(CNP, student.CNP);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
