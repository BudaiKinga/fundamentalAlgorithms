package stream.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class StreamBasics {
    public static void main(String[] args) {
        // elements are constructed on demand
        // a stream is consumed
        List<String> stringList = Arrays.asList("ana", "are", "mere");
        Stream<String> stringStream = stringList.stream();
        List<String> list1 = stringStream.limit(2).collect(Collectors.toList());
        System.out.println(list1);
        // Illegal state exception because stream is closed
//        List<String> list2 = stringStream
//                .limit(2)
//                .collect(Collectors.toList());
        stringStream = stringList.stream();
        stringStream.forEach(System.out::println);
        // IllegalStateException: stream has already been operated upon or closed
//        stringStream.forEach(System.out::println);

        // intermediate operations do not perform anything until terminal operations are called
        // .filter().map().filter() etc not executed until collect (that is terminal) is called
        list1 = stringList.stream()
                .filter(str -> {
                    System.out.println("Filtering " + str);
                    return str.length() > 0;
                })
                .map(str -> {
                    System.out.println("Map called on " + str);
                    return str;
                })
                .limit(2)
                .collect(Collectors.toList());

        // filter ana, map ana
        // filter are, map are
        // stop -> short-circuiting due to limit

        // terminal -> anything that does not result in a stream
        // foreach, collect, cound, reduce

    }
}
