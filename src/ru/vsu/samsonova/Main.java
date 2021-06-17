package ru.vsu.samsonova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = readNumberFromKeyboard("sum of numbers");
        List<Integer> list = new ArrayList<> ();
        list.add (1);
        list.add(7);
        list.add(11);
        list.add(33);
        list.add(9);
        list.add(28);
        list.add(4);
        list.add(15);
        list.add(2);
        list.add(22);
        List<List<Integer>> result = generateFinalList(list, s);
        printResultCombinations(result);
        }

        public static int readNumberFromKeyboard (String name){
            System.out.println("Input " + name + ":");
            Scanner scanner = new Scanner(System.in);
            String row = scanner.nextLine();
            int num = Integer.parseInt(row);
            return num;
        }

        public static List<List<Integer>> generateFinalList(List < Integer > list, int s){
            List<List<Integer>> result = new ArrayList<>();

            List<List<Integer>> allCombinations = formAllTriples(list);

            for (List<Integer> l :
                    allCombinations) {
                if (calculateSum(l) == s) {
                    result.add(l);
                }
            }

            return result;
        }

        public static List<List<Integer>> formAllTriples(List < Integer > list) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> additionalList = new ArrayList<>(3);
            for (int i = 0; i < list.size(); i++) {
                additionalList.add(0, list.get(i));

                for (int j = i + 1; j < list.size(); j++) {

                    additionalList.add(1, list.get(j));

                    for (int k = j + 1; k < list.size(); k++) {

                        additionalList.add(2, list.get(k));

                        result.add(new ArrayList<>(additionalList));

                        additionalList.remove(2);
                    }

                    additionalList.remove(1);
                }

                additionalList.remove(0);
            }

            return result;
        }

        public static int calculateSum (List < Integer > list) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return sum;
        }

        public static void printResultCombinations(List < List < Integer >> list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print("List №" + (i + 1) + ": ");
                for (int j = 0; j < list.get(i).size(); j++) {
                    System.out.print(list.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
}
