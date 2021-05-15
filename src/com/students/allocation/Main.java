package com.students.allocation;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(1L,"S1", 2);
        Student s2 = new Student(2L,"S2", 3);
        Student s3 = new Student(3L,"S3", 4);
        Student s4 = new Student(4L, "S4", 1);

        Project a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Project a2 = new Application("A2", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Project a3 = new Application("A3", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);

        Project e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Topic.ALGORITHMS);
        Project e2 = new Essay("E2", LocalDate.parse("2019-06-01"), Topic.ALGORITHMS);

        s1.addProject(a1);
        s1.addProject(a2);
        s1.addProject(a3);

        s2.addProject(a1);
        s2.addProject(e1);

        s3.addProject(a2);
        s3.addProject(a3);
        s3.addProject(e1);

        s4.addProject(a3);
        s4.addProject(e2);

        a1.addStudent(s2);
        a1.addStudent(s1);
        a1.addStudent(s3);
        a2.addStudent(s1);
        a2.addStudent(s4);
        a2.addStudent(s3);
        a3.addStudent(s3);
        a3.addStudent(s4);
        e1.addStudent(s3);
        e1.addStudent(s2);
        e2.addStudent(s4);
        e2.addStudent(s1);


        Problem problem = new Problem();

        problem.addStudent(s1);
        problem.addStudent(s2);
        problem.addStudent(s3);
        problem.addStudent(s4);

        problem.addProjects(a1);
        problem.addProjects(a2);
        problem.addProjects(a3);
        problem.addProjects(e1);
        problem.addProjects(e2);

        System.out.println(problem);
        System.out.println();
        problem.optimalSolution();
    }
}
