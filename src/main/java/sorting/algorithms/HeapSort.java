package sorting.algorithms;

public class HeapSort implements Sort
{
    // worst case Omega(nlgn)
    // if all elems are distinct best is Omega(nlgn)

    @Override
    public int[] sort(int[] param)
    {
        int[] array = param.clone();
        int heapSize = buildMaxHeap(array);
        for (int i = array.length; i >=1; i--)
        {
            exchange(array, 0, i-1);
            heapSize--;
            maxHeapify(array, heapSize, 0);

        }
        return array;
    }

    private int buildMaxHeap(int[] array)
    {
        int heapSize = array.length;
        for (int i = array.length / 2 -1; i >= 0; i--)
        {
            maxHeapify(array, heapSize, i);
        }
        return heapSize;
    }

    private void maxHeapify(int[] array, int heapSize, int i)
    {
        int left = leftIndex(i);
        int right = rightIndex(i);
        int largest = i;
        if (left < heapSize && array[left] > array[i])
        {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest])
        {
            largest = right;
        }
        if (largest != i)
        {
            exchange(array, i, largest);
            maxHeapify(array, heapSize, largest);
        }
    }

    private int leftIndex(int i)
    {
        return 2 * i +1;
    }

    private int rightIndex(int i)
    {
        return 2 * (i + 1);
    }

    private void exchange(int[] array, int i, int j)
    {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

}
