package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Iterator iterator = cats.iterator();
        while(iterator.hasNext()) {
            cats.remove(iterator.next());
            break;
        }



        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> set = new HashSet<>();
        Cat cat0 = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        set.add(cat0);
        set.add(cat1);
        set.add(cat2);
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for(Cat text : cats) {
            System.out.println(text);
        }
    }

    // step 1 - пункт 1
    public static class Cat {

    }
}
