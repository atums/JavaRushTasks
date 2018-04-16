package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu

Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    // Чем мой код не угодил не понимаю!!!!! Уж мой пароли точно уникальние
//    static boolean charUpper = false; // 1
//    static boolean charLower = false; // 2
//    static boolean charNumber = false; // 0
//
//    public static void main(String[] args) {
//        ByteArrayOutputStream password = getPassword();
//        System.out.println(password.toString());
//    }
//
//    public static ByteArrayOutputStream getPassword() {
//        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
//        for(int i = 0; i < 5; i++) {
//            bAOS.write(methodRandom());
//        }
//        for(int i = 0; i < 3; i++) {
//            if(!charUpper) {
//                charUpper = true;
//                bAOS.write((byte) (65 + Math.random() * 26));
//            } else if(!charLower) {
//                charLower = true;
//                bAOS.write((byte) (97 + Math.random() * 26));
//            } else if(!charNumber) {
//                bAOS.write((byte) (48 + Math.random() * 10));
//            } else {
//                bAOS.write(methodRandom());
//            }
//        }
//        return bAOS;
//    }
//
//    public static byte methodRandom() {
//        int x = (int) (Math.random() * 3);
//        byte result = 0;
//        switch(x) {
//            case 0 : {
//                charNumber = true;
//                result = ((byte) (48 + Math.random() * 9));
//                break;
//            }
//            case 1 : {
//                charUpper = true;
//                result = ((byte) (65 + Math.random() * 26));
//                break;
//            }
//            case 2 : {
//                charLower = true;
//                result = ((byte) (97 + Math.random() * 26));
//                break;
//            }
//        }
//        return result;
//    }
// Это не мое!
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String laters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer passw = new StringBuffer();

        for (int i=0; i<4; i++) {
            passw.append(laters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            passw.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            passw.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            output.write(passw.toString().getBytes());
        } catch (Exception e)
        {

        }

        return output;
    }

}