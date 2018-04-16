package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/*
1. В классе AmigoSet должен содержаться private метод writeObject с одним параметром типа ObjectOutputStream.
2. В классе AmigoSet должен содержаться private метод readObject с одним параметром типа ObjectInputStream.
3. В методе writeObject должен быть вызван метод defaultWriteObject на объекте типа ObjectOutputStream полученном в качестве параметра.
4. В методе readObject должен быть вызван метод defaultReadObject на объекте типа ObjectInputStream полученном в качестве параметра.
5. Объект сериализованный с помощью метода writeObject должен быть равен объекту десериализованному с помощью метода readObject.
 */

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size()/0.75f +1));
        map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet) super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch(Exception ex) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oOS) throws IOException {
        oOS.defaultWriteObject();
//        oOS.writeObject(map.keySet());
        oOS.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oOS.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        oOS.writeInt(map.size());

        for (E e : map.keySet()) oOS.writeObject(e);
    }

    private void readObject(ObjectInputStream oIS) throws IOException, ClassNotFoundException {
        oIS.defaultReadObject();

        int capacity = oIS.readInt();
        float loadFactor = oIS.readFloat();
        int size = oIS.readInt();

        map = new HashMap<>(capacity,loadFactor);

        for (int i = 0; i < size; i++)
        {
            E e = (E) oIS.readObject();
            map.put(e, PRESENT);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        if(map.isEmpty()) return true;

        return false;
    }

    @Override
    public boolean contains(Object o) {
        if(map.containsKey(o)) return  true;

        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if(map.containsKey(o)) {
            map.remove(o);
            return true;
        }
        return false;
    }
}
