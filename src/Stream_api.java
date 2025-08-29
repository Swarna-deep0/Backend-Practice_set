import java.util.*;
import java.util.stream.*;
class employee implements Comparable<employee>{
    int id;
    String name;
    int salary;
    String department;

    employee( int id, String name, int salary, String department){
        this.id =id;
        this.name =name;
        this.salary =salary;
        this.department =department;
    }

    @Override
    public int compareTo(employee other) {
        return Integer.compare(this.salary, other.salary);
    }

    public String toString(){
        return "[" + department  + " : $" + salary + " ]";
    }
}
public class Stream_api {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 45, 78, 23, 90, 12, 66);

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

        List<employee> l1 = Arrays.asList(
                new employee(1, "deep", 7000, "HR"),
                new employee(2, "Khusi", 5000, "Manager"),
                new employee(3, "animesh", 10000, "Manager"),
                new employee(4, "anil", 3000, "HR"),
                new employee(2, "Khusi", 5000, "IT"));
        employee highestPaid = l1.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
        System.out.println("Highest paid: " + highestPaid);

        // Highest salary from each department
        Map<String, employee> highestByDept = l1.stream()
                .collect(Collectors.toMap(
                        emp -> emp.department,
                        emp -> emp,
                        (e1, e2) -> e1.salary > e2.salary ? e1 : e2
                ));

        highestByDept.forEach((dept, emp) ->
                System.out.println(dept + ": " + emp));
        
        // Convert a list of strings to a single comma-separated string using Collectors.joining().
        List<String> L1 = List.of("sunil","anil","kunal");
        String result = L1.stream()
                .collect(Collectors.joining(","));
        System.out.println("Joined: " + result);
    }
}