package ru.vsu.samsonova;

import java.util.List;

public class MyMap {

    public static void main(String[] args) {
        int s = Main.readNumberFromKeyboard("sum of numbers");

        MapImplement<Integer, Integer> map = new MapImplement<>();
        map.put(1, 23);
        map.put(2, 0);
        map.put(3, 12);
        map.put(4, 8);
        map.put(5, 6);
        map.put(6, 7);
        map.put(7, 1);


        List<Integer> list = map.toList();

        List<List<Integer>> result = Main.generateFinalList(list, s);
        Main.printResultCombinations(result);
    }
}

