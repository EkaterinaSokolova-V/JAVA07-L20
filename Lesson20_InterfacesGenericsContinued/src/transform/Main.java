package transform;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 45, -7, 60, 3, -15, 0);
        System.out.println(Utils.multiplyByTwo(numbers));
        System.out.println(Utils.sumTwo(numbers));

        List<String> strings = List.of("Иван", "родил", "девчонку", "велел", "тащить", "пеленку");
        System.out.println(Utils.firstLetters(strings));

        System.out.println(Utils.filterList(numbers, number -> number < 0));
        System.out.println(Utils.filterList(numbers, x -> x % 2 != 0));
        System.out.println(Utils.filterList(strings, x -> x.length() == 5));
    }
}
