package dataStructures;

/**
 * Created by BudaiK on Mar, 2020.
 */
public class SegmentTreeForMin {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        st = new int[2 * (int) Math.pow(2, x) - 1];
        constructSegmentTree(arr, 0, n - 1, 0);
        return st;
    }

    private static int constructSegmentTree(int[] arr, int start, int end, int currentSTElem) {
        if (start == end) {
            st[currentSTElem] = arr[start];
        } else {
            int middle = getMiddle(start, end);
            int rightChild = 2 * currentSTElem + 1;
            int leftChild = 2 * currentSTElem + 2;
            st[currentSTElem] = Math.min(constructSegmentTree(arr, start, middle, rightChild),
                    constructSegmentTree(arr, middle+1, end, leftChild));
        }
        return st[currentSTElem];
    }

    private static int getMiddle(int start, int end) {
        return start + (end - start) / 2;
    }


    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r) {
        // validation
        if (l < 0 || r >=n || l>r) {
            return  -1;
        }
        return getMinElement(st, 0, 0, n-1, l, r);
    }

    private static int getMinElement(int[] st, int current, int currentStart, int currentEnd, int qs, int qe) {
        // we have to parse the whole tree and check for branches that are inside the interval
        // segment [qs,qe] contains segment [currS, currE] => return this node
        if (currentStart >= qs && currentEnd <=qe) {
            return st[current];
        }
        // segment [cs, ce] outside [qs, qs]
        if (currentStart >qe || currentEnd < qs ) {
            // if branch is outside the query
            return Integer.MAX_VALUE;
        }
        // [cs, ce] contains [qs, qe]
        int middle = getMiddle(currentStart, currentEnd);
        int left = getMinElement(st, 2* current +1,currentStart, middle, qs, qe);
        int right = getMinElement(st, 2*current +2,middle +1, currentEnd, qs, qe);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11};
        constructST(arr, arr.length);
        int min = getMinElement(st, 0, 0, arr.length -1, 1,4);
        System.out.println(min);
    }
}
