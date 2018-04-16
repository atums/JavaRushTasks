package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.javarush.task.task20.task2002.User.Country.OTHER;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("e:\\!!.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user0 = new User();
            user0.setFirstName("Vasa");
            user0.setLastName("Kvasa");
            user0.setBirthDate(new Date(11, 11, 2011));
            user0.setMale(true);
            user0.setCountry(OTHER);

            javaRush.users.add(user0);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
//            if(javaRush == loadedObject) {
//                System.out.println("Yes!");
//            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataOutputStream writer = new DataOutputStream(outputStream);

            writer.writeInt(users.size());

            for(User list : users) {
                String firstName = (list.getFirstName() == null) ? "null" : list.getFirstName();
                writer.writeUTF(firstName);
                String lastName = (list.getLastName() == null) ? "null" : list.getLastName();
                writer.writeUTF(lastName);
                writer.writeLong(list.getBirthDate().getTime());
                writer.writeBoolean(list.isMale());
                writer.writeUTF(list.getCountry().name());
            }
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataInputStream reader = new DataInputStream(inputStream);


            int usersCount = reader.readInt();
            for(int i = 0; i < usersCount; i++) {

                User user = new User();

                String firstName = reader.readUTF();
                if (firstName.equals("null")) firstName = null;
                user.setFirstName(firstName);
                String lastName = reader.readUTF();
                if (lastName.equals("null")) lastName = null;
                user.setLastName(lastName);
                user.setBirthDate(new Date(reader.readLong()));
                user.setMale(reader.readBoolean());
                user.setCountry(User.Country.valueOf(reader.readUTF()));

                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
