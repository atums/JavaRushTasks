package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:

        for(Student wantedStudent : students) {
            if(wantedStudent.getAverageGrade() == averageGrade) {
                return wantedStudent;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double max = 0.0d;
        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getAverageGrade() > max) {
                max = students.get(i).getAverageGrade();
            }
        }
        for(Student wantedStudent : students) {
            if(wantedStudent.getAverageGrade() == max) {
                return wantedStudent;
            }
        }
        return null;
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }

    public Student getStudentWithMinAverageGrade() {
        double min = students.get(0).getAverageGrade();
        int badIndex = 0;
        for(int i = 1; i < students.size(); i++) {
            if(students.get(i).getAverageGrade() < min) {
                min = students.get(i).getAverageGrade();
                badIndex = i;
            }
        }
        for(Student wantedStudent : students) {
            if(wantedStudent.getAverageGrade() == min) {
                return wantedStudent;
            }
        }
        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}