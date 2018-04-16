package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human man0 = new Human("Дед 1", true, 62);
        Human man1 = new Human("Бабка 1", false, 61);
        Human man2 = new Human("Дед 2", true, 59);
        Human man3 = new Human("Бабка 2", false, 60);
        Human man4 = new Human("Отец 0", true, 39, man0, man1);
        Human man5 = new Human("Мать 0", false, 41, man2, man3);
        Human man6 = new Human("Def1", false, 13, man4, man5);
        Human man7 = new Human("Def2", false, 11, man4, man5);
        Human man8 = new Human("Def3", false, 8, man4, man5);

        System.out.println(man0.toString());
        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(man3.toString());
        System.out.println(man4.toString());
        System.out.println(man5.toString());
        System.out.println(man6.toString());
        System.out.println(man7.toString());
        System.out.println(man8.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        boolean sex;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















