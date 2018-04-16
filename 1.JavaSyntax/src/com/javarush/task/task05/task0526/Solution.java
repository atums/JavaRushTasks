package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man0 = new Man("Vasa", 45, "Bolshevikov, 45");
        Man man1 = new Man("Sasha", 41, "Novoizm, 37");
        Woman woman0 = new Woman("Rita", 32, "Piskar, 21");
        Woman woman1 = new Woman("Anna", 40, "Duklo, 2");
        System.out.println(man0.name + " " + man0.age + " " + man0.address);
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(woman0.name + " " + woman0.age + " " + woman0.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);

    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

    }
}
