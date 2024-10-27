package org.pollub.Lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Z1.");
        zad1();

        System.out.println("Z2.");
        zad2();

        System.out.println("Z3.");
        zad3();

        System.out.println("Z4.");
        zad4();

        System.out.println("Z5.");
        zad5();

    }

    public static void zad1(){
        ArrayList<String> desserts = new ArrayList<>();
        desserts.add("fondant");
        desserts.add("banana bread");
        desserts.add("chocolate chip cookies");
        desserts.add("milky way cake");
        desserts.add("souffle");
        desserts.add("banana split");
        desserts.add("red velvet cake");
        desserts.add("new york cheesecake");

        System.out.println("***DESSERTS WITH BANANAS***");
        desserts.stream().filter(element -> element.contains("banana")).forEach(System.out::println);

        System.out.println();

        System.out.println("***CAKES***");
        desserts.stream().filter(element -> element.contains("cake")).forEach(System.out::println);

        System.out.println();

        System.out.println("***CHOCOLATE DESSERTS***");
        desserts.stream().filter(element -> element.contains("chocolate")).forEach(System.out::println);
    }
    public static void zad2(){
        List<String> fruits = Arrays.asList("apple", "banana", "grape", "orange", "banana", "orange", "apple", "banana", "watermelon", "raspberry", "watermelon");

        Map<String, Long> fruitsCounter = fruits.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println("Fruits counter:");
        fruitsCounter.forEach((fruit, count) -> System.out.println(fruit + ": " + count));

        System.out.println();

        System.out.println("Fruit counter > 1:");
        fruitsCounter.forEach((fruit, count) -> {
            if(count > 1) {
                System.out.println(fruit + ": " + count);
            }
        });
    }
    public static void zad3(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squaredNumbers = numbers.stream().map(n -> n * n).toList();

        System.out.print("Numbers: " + numbers + "\n");
        System.out.println("Squared numbers: " + squaredNumbers);
    }
    public static void zad4(){

        System.out.println("I'm writing something to the file! Please wait! :)");
        writeToFile();

        System.out.println();

        System.out.println("Here's the content of the written file:");
        readFromFile("myFile.txt");

    }
    public static void zad5(){
        writeToFile();
        System.out.println("Here's the content of the written file before sorting:");
        readFromFile("letters.txt");
        System.out.println();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("letters.txt"));
            List<String> lines = new ArrayList<>();
            String line;

            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
            bufferedReader.close();

            System.out.println("Here's the content of the written file after sorting:");
            lines.stream().sorted().forEach(System.out::println);

        } catch(FileNotFoundException e){
            System.out.println("File not found");
            System.err.println(e.getCause());
        } catch(IOException e){
            System.out.print("An error occurred during reading file: ");
            System.err.println(e.getCause());System.out.println();
        }
    }

    public static void writeToFile(){
        File file = new File("myFile.txt");

        try{
            FileWriter fileWriter = new FileWriter(file, true);

            for(int i=0; i<10; i++){
                fileWriter.append("Line no.: " + (i+1) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    public static void readFromFile(String filename){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;

            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.err.println(e.getCause());
        } catch (IOException e) {
            System.out.print("An error occurred during reading file: ");
            System.err.println(e.getCause());
        }
    }
}