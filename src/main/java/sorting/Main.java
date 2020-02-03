package sorting;

import java.util.LinkedList;
import java.util.List;
import sorting.algorithms.HeapSort;
import sorting.algorithms.InsertionSort;
import sorting.algorithms.Sort;

public class Main
{
    public static void main(String[] args)
    {
        List<Sort> sortingAlgorithms = new LinkedList<>();
        //sortingAlgorithms.add(new InsertionSort());
        sortingAlgorithms.add(new HeapSort());
        Data data = new Data();
        for (Sort sortingAlg : sortingAlgorithms)
        {
            for (int[] input : data.data)
            {
                int[] res = sortingAlg.sort(input);
                prettyPrint(res);
            }
        }
    }

    private static void prettyPrint(int[] values)
    {
        for (int v : values)
        {
            System.out.print(v + " ");
        }
        System.out.println();
    }

}
