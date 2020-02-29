package geeksForGeeks.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BudaiK on Feb, 2020.
 * https://practice.geeksforgeeks.org/problems/frequency-game/1
 */
class FrequencyGame {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int elem : arr) {
            Integer frequency = freqs.get(elem);
            if (frequency == null) {
                frequency = 0;
            }
            frequency++;
            freqs.put(elem, frequency);
        }
        int freq = Integer.MAX_VALUE;
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() <= freq && entry.getKey() > max) {
                freq = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;

    }
}