package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            if(loadWheelNamesFromDB().length == 4) {
                wheels = new ArrayList<>();
                for(String str : loadWheelNamesFromDB()) {
                    wheels.add(Wheel.valueOf(str));
                }
            } else {
                throw new Exception();
            }
//            System.out.println(wheels.size());
//            for(Wheel wheelstr : wheels) {
//                System.out.println(wheelstr);
//            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
//        Car car = new Car();
    }
}
