package geeksForGeeks;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] stocks = new int[]{10, 7, 5, 8, 11, 9, 12};
        int[] d = new int[stocks.length - 1];
        for (int i = 0; i < stocks.length - 1; i++) {
            d[i] = stocks[i + 1] - stocks[i];
        }

        int maxd = 0, maxs = 0, maxe = 0;
        int currd = 0, currs = 0, curre = 0;

        while (curre < d.length) {
            currd += d[curre];
            if (currd > maxd) {
                maxd = currd;
                maxe = curre;
                maxs = currs;
                curre++;
                continue;
            }
            if (currd > 0) {
                curre++;
            } else {
                currs = curre + 1;
                currd = 0;
                curre = currs;
            }
        }
        System.out.println(maxs + " " + maxe + " " + maxd);
    }
}
