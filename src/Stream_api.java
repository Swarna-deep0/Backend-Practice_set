import java.util.*;
import java.util.stream.Stream;

public class Stream_api {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2,45,78,23,90,12,66);

        // Finding the second largest
        Integer secondlargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        
        System.out.println("Second largest: " + secondlargest);

        // Finding the second minimum
        Integer secondMin = numbers.stream()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Second minimum: " + secondMin);
    }
}