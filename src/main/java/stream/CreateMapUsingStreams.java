package stream;

import stream.model.SimpleObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class CreateMapUsingStreams {

    public static void main(String[] args) {
        SimpleObject ob1 = new SimpleObject(1, "Boldi");
        SimpleObject ob2 = new SimpleObject(2, "Kinga");

        List<SimpleObject> objects = Arrays.asList(ob1, ob2);

        // Reduce is used to reduce values to a single element
        BinaryOperator<Integer> simpleObjectBinaryOperator = Integer::sum;
        int idSum = objects.stream().map(SimpleObject::getId).reduce(0, simpleObjectBinaryOperator);
        System.out.println("First sum: " + idSum);


        Map<Integer, SimpleObject> myMapOfObjects = objects.stream()
                .collect(Collectors.toMap(SimpleObject::getId, Function.identity()));

        myMapOfObjects.entrySet().stream().forEach( entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        int idSum2 = objects.stream().reduce(0, (partialSum, object) -> partialSum + object.getId() * 2, Integer::sum);
        System.out.println(idSum2);


        Map<Integer, List<SimpleObject>> myMapOfObjects2 = objects.stream().collect(groupingBy(SimpleObject::getId));
    }
}
