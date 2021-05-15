package com.students.allocation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Project {

    private String name;
    private LocalDate deadline;
    private List<Student> preferredStudents;
    private Student assignedStudent;

    public Project(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
        preferredStudents = new ArrayList<>();
        this.assignedStudent = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void addStudent(Student student) {
        this.preferredStudents.add(student);
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public void setAssignedStudent(Student assignedStudent) {
        this.assignedStudent = assignedStudent;
    }

    @Override
    public String toString(){

        String result = "sunt proiectul " + name + " si imi plac urmatorii studenti: ";
        for (int i = 0; i < preferredStudents.size(); i++) {
            Student student = preferredStudents.get(i);
            result = result + student.getName();
            if (i < preferredStudents.size() - 1) {
                result = result + ", ";
            }
        }
        return result;
    }


    public boolean prefersFirstOverSecond(Student first, Student second) {
        for(Student student : preferredStudents){
            if(student.equals(first)) {
                return true;
            }
            if(student.equals(second)){
                return false;
            }
        }

        throw new IllegalArgumentException();
    }
}
