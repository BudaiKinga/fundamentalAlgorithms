package sorting.algorithms;

public class InsertionSort implements Sort
{
    // O(n^2) - both worst and avg
    @Override
    public int[] sort(int[] array)
    {
        int[] res = array.clone();
        // first element "in order" start sorting with the second element
        for (int i = 1; i < res.length; i++)
        {
            int valueToPut = res[i];
            int compareIndex = i-1;
            while (compareIndex >= 0 && res[compareIndex] > valueToPut) {
                // shift element at index to right
                res[compareIndex+1] = res[compareIndex];
                // step with index one to the left
                compareIndex--;
            }
            // put right before compared elem
            res[compareIndex+1] = valueToPut;
        }
        return res;
    }
}
