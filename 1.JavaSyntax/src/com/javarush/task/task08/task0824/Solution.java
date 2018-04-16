package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> chGrandMom0 = new ArrayList<Human>();
        ArrayList<Human> chGrandMom1 = new ArrayList<Human>();
        ArrayList<Human> chGrandPa0 = new ArrayList<Human>();
        ArrayList<Human> chGrandPa1 = new ArrayList<Human>();
        ArrayList<Human> chFather = new ArrayList<Human>();
        ArrayList<Human> chMother = new ArrayList<Human>();

        Human grandMom0 = new Human("GrandMom0", false, 65, chGrandMom0);
        Human grandMom1 = new Human("GrandMom1", false, 67, chGrandMom1);
        Human grandPa0 = new Human("GrandPa0", true, 68, chGrandPa0);
        Human grandPa1 = new Human("GrandPa1", true, 67, chGrandPa1);
        Human father = new Human("Father", true, 34, chFather);
        Human mother = new Human("Mother", false, 33, chMother);
        Human baby0 = new Human("Baby0", true, 8);
        Human baby1 = new Human("Baby1", false, 5);
        Human baby2 = new Human("Baby2", true, 3);


        Collections.addAll(chGrandMom0, father);
        Collections.addAll(chGrandMom1, mother);
        Collections.addAll(chGrandPa1, mother);
        Collections.addAll(chGrandPa0, father);
        Collections.addAll(chFather, baby0, baby1, baby2);
        Collections.addAll(chMother, baby0, baby1, baby2);

        System.out.println(grandMom0.toString());
        System.out.println(grandMom1.toString());
        System.out.println(grandPa0.toString());
        System.out.println(grandPa1.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(baby0.toString());
        System.out.println(baby1.toString());
        System.out.println(baby2.toString());

        System.out.println();
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
