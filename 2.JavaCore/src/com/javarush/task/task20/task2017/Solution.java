package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    A test;
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            test = (A) objectStream.readObject();
//        } catch(NotSerializableException e) {
//            return null;
//        } catch (IOException e) {
////            e.printStackTrace();
//            return null;
//        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
//            return null;
//        }
        } catch(Exception ex) {
            return null;
        }
        return test;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
