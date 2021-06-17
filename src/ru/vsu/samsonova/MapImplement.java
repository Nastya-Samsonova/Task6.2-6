package ru.vsu.samsonova;

import java.util.ArrayList;
import java.util.List;

public class MapImplement<V,K>{
    private Element[] elements = new Element[15];
    private int size = 0;

    public boolean put(K key, V value) {

        if (containsKey(key)){
            System.out.println("Element with key " + key + " already exists.");
            return false;
        }

        Element newElement = new Element(key, value);

        if (size == elements.length) {
            Element[] temp = new Element[elements.length + (elements.length * 2 / 3) + 1];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }

        elements[size] = newElement;
        size++;
        return true;
    }

    public void print() {
        int i = 1;
        for (int j = 0; j < size; j++) {
            System.out.println(i + ". " + elements[j]);
            i++;
        }
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            Element e = elements[i];
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            Element e = elements[i];
            if (e.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = new Element[10];
        size = 0;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            Element<K, V> e = elements[i];
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        System.out.println("Object with key " + key + " doesn't exist.");
        return null;
    }

    public void putAll(MapImplement<K, V> myMapImpl) {
        for (int i = 0; i < myMapImpl.getSize(); i++) {
            Element<K, V> element = myMapImpl.elements[i];
            put(element.getKey(), element.getValue());
        }
    }

    public Element[] entrySet() {
        return elements;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Element<K, V> e = elements[i];
            values.add(e.getValue());
        }

        return values;
    }

    public String keySet(){
        String keys = "{";

        for (int i = 0; i < size; i++) {
            keys += elements[i].getKey() + ", ";
        }

        keys += "}";
        return keys;
    }

    public boolean remove(K key) {
        if (!containsKey(key)) {
            System.out.println("Object with " + key + " doesn't exist.");
            return false;
        }

        Element[] temp = new Element[elements.length - 1];

        int index = 0;
        for (int i = 0; i < size; i++) {

            Element element = elements[i];

            if (element.getKey().equals(key)) {
                continue;
            }

            temp[index] = element;
            index++;
        }

        elements = temp;

        size--;
        return true;
    }

    public List<V> toList() {
        List<V> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((V) elements[i].getValue());
        }

        return list;
    }

}
