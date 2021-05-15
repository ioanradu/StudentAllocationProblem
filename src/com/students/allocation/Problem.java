package com.students.allocation;

import java.util.*;

public class Problem {

    private List<Student> students;
    private List<Project> projects;
    private Map<Student, Project> studentProject;

    public Problem() {

        this.students = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.studentProject = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void addProjects(Project project){
        this.projects.add(project);
    }


    public void solve(){

        Queue<Student> availableStudents = new LinkedList<>(students); // copie lista students intr-o lista noua
        Queue<Project> availableProjects = new LinkedList<>(projects); // copie lista projects intr-o lista noua
        // daca proiectul prefaerat se afla in lista de proiecte disponibile

        while(!availableStudents.isEmpty()){
            Student student = availableStudents.poll();
            List<Project> preferredProjects = student.getPreferredProjects();
            for (Project preferredProject: preferredProjects){

                if(availableProjects.contains(preferredProject)){
                    // s-a gasit potrivire (match)
                    student.setAssignedProjects(preferredProject);
                    preferredProject.setAssignedStudent(student);
                    availableProjects.remove(preferredProject); // dupa ce se pupa ii scot din lista available
                    availableStudents.remove(student); // // dupa ce se pupa ii scot din lista available
                    break;
                }
            }
        }

        for(Student each : students){
            System.out.println("I am " + each.getName()+ " and I was assigned the following project: " + each.getAssignedProjects().getName());
        }
    }

    // a doua solutie si cea optima a lui solve()
    public void optimalSolution(){
        Queue<Student> studentQueue = new LinkedList<>(students);
        Map<Student, Queue<Project>> studentPreferences = new HashMap<>();
        for(Student student : students){
            Queue<Project> projectQueue = new LinkedList<>(student.getPreferredProjects());
            studentPreferences.put(student, projectQueue);
        }
        while(studentQueue.isEmpty() == false){
            Student student = studentQueue.poll();
            Queue<Project> studentProjectsQueue = studentPreferences.get(student);
            Project preferredProject = studentProjectsQueue.poll();

            if(preferredProject.getAssignedStudent() == null){// daca nu e alocat
                //project was not alocated to the same student
             student.setAssignedProjects(preferredProject);
             preferredProject.setAssignedStudent(student);
            }else {

                Student initialStudent = preferredProject.getAssignedStudent();
                boolean initialStudentShouldStay = preferredProject.prefersFirstOverSecond(initialStudent, student);
                if(initialStudentShouldStay){
                    studentQueue.add(student);
                } else {
                    initialStudent.setAssignedProjects(null);
                    student.setAssignedProjects(preferredProject);
                    preferredProject.setAssignedStudent(student);
                    studentQueue.add(initialStudent);
                }
            }
        }
        for(Student each : students){
            System.out.println("I am " + each.getName()+ " and I was assigned the following project: " + each.getAssignedProjects().getName());
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("There are " + students.size() + " students and " + projects.size() + " projects");
        sb.append("\n");
        for(int i = 0; i < students.size(); i++){
            Student studentDeAfisat = students.get(i);
            sb.append("\n");
            sb.append(studentDeAfisat);

        };

        sb.append("\n");
        for (int i = 0; i < projects.size(); i++) {
            Project projectDeAfisat = projects.get(i);
            sb.append("\n");
            sb.append(projectDeAfisat);
        }
        return sb.toString();

    }


}
