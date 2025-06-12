package basicproblemsstreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicProblemsStreams {

    /*Partition a list of integers into even and odd numbers*/
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(partitioned);

        /*Flatten a list of lists using flatMap*/

        List<List<String>> nested = Arrays.asList
                (Arrays.asList("Java", "Spring"),
                Arrays.asList("Docker", "Kubernetes")
                );
        List<String> flatList = nested.stream().flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flatList);

        /*Find all numbers starting with 2 in a list*/

        List<Integer> allNumbers = Arrays.asList(1,2,25,30,26,31);
        List<Integer> result = allNumbers.stream()
                .map(String::valueOf)
                .filter(num->num.startsWith("2"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
