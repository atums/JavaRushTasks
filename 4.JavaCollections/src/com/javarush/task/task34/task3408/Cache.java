package com.javarush.task.task34.task3408;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if(!cache.containsKey(key)) {
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method method;
        try {
            // Используя рефлексию получи ссылку на метод, описанный в K getKey()
            method = obj.getClass().getDeclaredMethod("getKey");
            // Используя рефлексию разреши к нему доступ.
            method.setAccessible(true);
            //Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key
            cache.put((K) method.invoke(obj), obj);
            // Добавь в кэш пару <key, obj>.
            return cache.containsKey((K) method.invoke(obj));

        } catch (Exception e){

        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
