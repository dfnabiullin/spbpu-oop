import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static OptionalDouble getAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average();
    }

    private static List<String> transformStrings(List<String> list) {
        return list.stream().map(s -> "_new_" + s.toUpperCase()).toList();
    }

    private static List<Double> getSquares(List<Double> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey() * entry.getKey()).toList();
    }

    private static List<String> getSortedStringsStartingWith(Collection<String> collection, char prefix) {
        return collection.stream().filter(s -> s.startsWith(String.valueOf(prefix))).sorted().collect(Collectors.toList());
    }

    private static <T> T getLast(Collection<T> collection) {
        return collection.stream().reduce((_, t) -> t).orElseThrow();
    }

    private static int getSumEven(int[] ints) {
        return Arrays.stream(ints).filter(i -> i % 2 == 0).sum();
    }

    private static Map<Character, String> toMapByFirstChar(List<String> list) {
        return list.stream().collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1), (_, s) -> s));
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("A method that returns the average value of a list of integers: " + integerList + " " + getAverage(integerList));
        List<String> stringList = Arrays.asList("Zero", "One", "Two", "Three", "Four");
        System.out.println("A method that converts all lines in the list to uppercase and adds the prefix \"_new_\" to them: " + stringList + " " + transformStrings(stringList));
        List<Double> doubleList = Arrays.asList(0.0, 0.5, 1.0, 1.5, 1.5, 2.0);
        System.out.println("A method that returns a list of squares of all items in the list that occur only once: " + doubleList + " " + getSquares(doubleList));
        System.out.println("A method that accepts a collection of strings as input and returns all strings starting with a given letter, sorted alphabetically: " + stringList + " " + getSortedStringsStartingWith(stringList, 'T'));
        System.out.println("A method that accepts a collection as input and returns its last element, or throws an exception if the collection is empty: " + stringList + " " + getLast(stringList));
        int[] ints = {0, 1, 2, 3, 4, 5};
        System.out.println("A method that accepts an array of integers as input, returning the sum of even numbers or 0 if there are no even numbers: " + Arrays.toString(ints) + " " + getSumEven(ints));
        System.out.println("A method that converts all the rows in the list to a Map, where the first character is the key and the remaining characters are the value: " + stringList + " " + toMapByFirstChar(stringList));
    }
}