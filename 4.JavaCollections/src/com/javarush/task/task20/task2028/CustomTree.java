package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)

Тебе необходимо реализовать:
1. метод add(String s) - добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
искать место для вставки начинаем слева направо.

2. метод remove(Object o) - удаляет элемент дерева имя которого было полученного в качестве параметра.
3. метод size() - возвращает текущее количество элементов в дереве.
4. метод getParent(String s) - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.


Требования:
1. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
2. После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
3. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и
является степенью двойки), N - размер дерева до удаления.

4. Метод getParent должен возвращать имя родителя для любого элемента дерева.
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    Entry<String> root;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
//        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public void add(String s) {

    }

    public boolean remove(Object o) {
        return false;
    }

    public void getParent(String s) {

    }

    @Override
    public int size() {
        return 0;
    }
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
//    public void add(int index, String element) {
//        throw new UnsupportedOperationException();
//    }
//    public String remove(int index) {
//        throw new UnsupportedOperationException();
//    }
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if(leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if(rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}
