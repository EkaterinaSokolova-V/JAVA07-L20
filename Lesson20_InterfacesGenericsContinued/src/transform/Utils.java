package transform;

import java.util.ArrayList;
import java.util.List;

public class Utils{
    public static List<Integer> multiplyByTwo(List<Integer> source) {
//        List<Integer> result = new ArrayList<>();
//        for (Integer i: source) {
//            result.add(i * 2);
//        }
//        return result;

//        Transformer<Integer> multiplyByTwo = new Transformer<>() {
//            @Override
//            public Integer transform(Integer original) {
//                return original * 2;
//            }
//        };
        //lambda works only if there is one method in one implemented interface.
        Transformer<Integer> multiplyByTwo = original -> original * 2;
        return transformList(source, multiplyByTwo);
    }

    public static List<Integer> sumTwo(List<Integer> source) {
//        List<Integer> result = new ArrayList<>();
//        for (Integer i: source) {
//            result.add(i + 2);
//        }
//        return result;
        //for java: is class sumTwoTransformer extends Transformer
//        class SumTwoTransformer implements Transformer<Integer> {
            //here define an anonymous nested class
            //sumTwo is instance of nested anonymous class
            //we use this syntactics to simplify the code, because then we don't need this class
            //so sumTwo is the only exemplar of class
            //Transformer sumTwo = new Transformer() {
//            @Override
//            public Integer transform(Integer original) {
//                return original + 2;
//            }
//        }
//        SumTwoTransformer sumTwo = new SumTwoTransformer();
        Transformer<Integer> sumTwo = original -> original + 2;
        return transformList(source, sumTwo);
    }

    public static List<String> firstLetters(List<String> source) {
//        Transformer<String> getFirstLetter = new Transformer<String>() {
//            @Override
//            public String transform(String original) {
//                return String.valueOf(original.charAt(0));
//            }
//        };
//        Transformer<String> getFirstLetter = original -> String.valueOf(original.charAt(0));
        return transformList(
                source,
                original -> String.valueOf(original.charAt(0)));
    }

    public static <T> List<T> transformList(List<T> source, Transformer<T> transformer) {
        List<T> result = new ArrayList<>();
        for (T i: source) {
            T transformed = transformer.transform(i);
            result.add(transformed);
        }
        return result;
    }

//    public static List<Integer> onlyNegative(List<Integer> source) {
////        Checker<Integer> checker = (Integer number) -> number < 0;
//        Checker<Integer> checker = new Checker<Integer>() {
//            @Override
//            public boolean check(Integer value) {
//                return value < 0;
//            }
//        };
//        return filterList(source, checker);
////        return filterList(source, x -> x < 0);
//    }

    public static <T> List<T> filterList(List<T> source, Checker<T> checker) {
        List<T> result = new ArrayList<>();
        for (T currentElement: source) {
            if (checker.check(currentElement)) {
                result.add(currentElement);
            }
        }
        return result;
    }
}
