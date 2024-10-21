package org.pollub.Lab2;/*
1.Utwórz strumień i wyszukaj w nim elementy poprzez zastosowanie filtra. - 2 p.
2.Utwórz strumień i policz elementy powtarzające się i ile razy się powtarzają. - 2 p.
3.Zastosuj mapowanie na strumieniu i utwórz nowy strumień powstały w jego wyniku. - 2 p.
4.Zastosuj zapis i odczyt danych z pliku tekstowego. Wykorzystaj do tego strumienie z biblioteki java.io oraz metody oferowane przez bibliotekę java.nio. - 4 p.
5.Zastosuj filtrowanie i sortowanie danych zapisywanych lub odczytywanych z pliku. - 4 p.
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static ArrayList<String> initList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Lava cake");
        list.add("Apple pie");
        list.add("Cupcake");
        list.add("Chocolate cake");
        list.add("Choclote brownie");
        list.add("Lemon pie");
        list.add("Apple crumble");
        list.add("Cupcake");
        list.add("Apple crumble");
        return list;
    }

    //1.
    public static void findInStream(ArrayList<String> list, String key) {
        Stream<String> stream = list.stream()
                .filter(s -> s.contains(key));

        stream.forEach(System.out::println);
    }


    //2.
    public static void countRepeatedElements(ArrayList<String> list) {
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long countRepeated = map.values().stream()
                .filter(v -> v > 1)
                .count();

        long countAll = map.values().stream()
                .filter(v -> v > 1)
                .mapToLong(Long::longValue)
                .sum();

        System.out.println("Mapa elementów z liczbą powtórzeń: ");
        map.forEach((k, v) -> System.out.println(k + " - " + v));
        System.out.println("Liczba elemntów powtórzonych:" + countRepeated);
        System.out.println("Suma powtarzających się elementów: " + countAll);
    }

    //3.
    public static void mapInStream(ArrayList<String> list) {
        Stream<String> stream = list.stream()
                .distinct()
                .map(s -> s + " - " + s.length());
        stream.forEach(System.out::println);
    }

    //4.

    public static void writeFile(ArrayList<String> list, String filePath) {
        Path path = Paths.get(filePath);
        File file = new File(filePath);
        try {
            Files.write(path, list, StandardOpenOption.APPEND);
            FileWriter fileWriter = new FileWriter(file,
                    true);
            try {
                for (String s : list) {
                    fileWriter.write(s + "\n");
                }
            } catch (IOException ex) {
                System.err.println(ex.getCause());
            }
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.getCause());
        }
    }


    public static ArrayList<String> readFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            return new ArrayList<>(lines);
        } catch (FileNotFoundException ex) {
            System.out.println("Pliku nie odnaleziono!");
            System.err.println(ex.getCause());
            return null;
        } catch (IOException ex) {
            System.out.println("Błąd odczytu pliku spowodowany:");
            System.err.println(ex.getCause());
            return null;
        }
    }



    private static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public static void saveReadAndSortFile(ArrayList<String> list, String filePath) {
        ArrayList<String> readList = new ArrayList<>();
        writeFile(list, filePath);
        readList = readFile(filePath);
        assert readList != null;
        readList.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println("Zapisane i odczytane posortowane dane: ");
        readList.forEach(System.out::println);
    }

    //5.
    public static void filterAndSortFile(ArrayList<String> list, String filePath) {
        ArrayList<String> readList = new ArrayList<>();
        readFile(filePath);
        readList = readFile(filePath);
        assert readList != null;
        readList.stream()
                .filter(s -> s.contains("Zenon"))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        String filePath = "src/file.txt";
        ArrayList<String> list = initList();
        System.out.println("Zadanie 1:");
        findInStream(list, "cake");
        System.out.println("\nZadanie 2:");
        countRepeatedElements(list);
        System.out.println("\nZadanie 3:");
        mapInStream(list);
        System.out.println("\nZadanie 4:");
        saveReadAndSortFile(list, filePath);
        System.out.println("\nZadanie 5:");
        filterAndSortFile(list, filePath);

        if (deleteFile(filePath)) {
            System.out.println("\nPlik został usunięty");
        } else {
            System.out.println("\nPlik nie został usunięty");
        }
    }
}


