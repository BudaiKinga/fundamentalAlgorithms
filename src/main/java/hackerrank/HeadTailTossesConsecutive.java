package hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BudaiK on Mar, 2020.
 */
public class HeadTailTossesConsecutive {

    private static final String HEAD = "HEADS";
    private static final String TAIL = "TAILS";
    private static List<Integer> getMaxStreaks(List<String> toss) {
        int headMax = 0;
        int tailMax = 0;
        int head = 0; int tail = 0;
        String prev = null;
        for (String t : toss){
            // if first element:
            if (prev == null) {
                if (HEAD.equals(t)) {
                    head++;
                } else {
                    tail ++;
                }
            } else {
                // continue streak
                if (t.equals(prev)) {
                    if (HEAD.equals(t)) {
                        head++;
                    } else {
                        tail++;
                    }
                } else {
                    //reset counter;
                    if (HEAD.equals(t)) {
                        head =1;
                    } else {
                        tail = 1;
                    }
                }
            }
            prev = t;
            if (head > headMax) {
                headMax = head;
            }
            if (tail > tailMax) {
                tailMax = tail;
            }
        }

        return Arrays.asList(headMax, tailMax);
    }

    public static void main(String[] args) {
        System.out.println(getMaxStreaks(Arrays.asList(HEAD, HEAD, HEAD, TAIL, TAIL, HEAD, TAIL)));
        System.out.println(getMaxStreaks(Arrays.asList(HEAD, HEAD, HEAD, HEAD)));
        System.out.println(getMaxStreaks(Arrays.asList(TAIL, TAIL, TAIL)));
        System.out.println(getMaxStreaks(Arrays.asList(TAIL, HEAD, TAIL)));
    }

}
