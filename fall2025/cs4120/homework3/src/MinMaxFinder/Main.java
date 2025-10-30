package MinMaxFinder;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{5, 2, 9, 1, 7};
        MinMaxFinder<Integer> intFinder = new MinMaxFinder<>(intArray);
        System.out.println("Integer Array: " + Arrays.toString(intArray));
        System.out.println(String.format("Min: %d, Max: %d", intFinder.findMin(), intFinder.findMax()));
        System.out.println();

        Double[] doubleArray = new Double[]{3.5, 7.2, 1.8, 9.0};
        MinMaxFinder<Double> doubleFinder = new MinMaxFinder<>(doubleArray);
        System.out.println("Double Array: " + Arrays.toString(doubleArray));
        System.out.println(String.format("Min: %f, Max: %f", doubleFinder.findMin(), doubleFinder.findMax()));
        System.out.println();

        String[] stringArray = new String[]{"Apple", "Mango", "Banana", "Cherry"};
        MinMaxFinder<String> stringFinder = new MinMaxFinder<>(stringArray);
        System.out.println("String Array: " + Arrays.toString(stringArray));
        System.out.println(String.format("Min: %s, Max: %s", stringFinder.findMin(), stringFinder.findMax()));
    }
}
