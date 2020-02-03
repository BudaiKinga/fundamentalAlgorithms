package dynamicProgramming;

import java.util.Set;

public class LongestCommonSubsequence
{
    private static final String STR1 = "ABCDGH";
    private static final String STR2 = "AEDFHR";

    public String getLCS(String str1, String str2)
    {
        String res = "";
        int currentPosInSecond = -1;
        int lastPosInSecond = -1;
        int currentPosInFirst = 0;
        while (currentPosInFirst < str1.length())
        {
            Character ch = str1.charAt(currentPosInFirst);
            currentPosInSecond = str2.indexOf(ch);
            {
                if (currentPosInSecond != -1)
                {
                    // character found in second
                    if (currentPosInSecond > lastPosInSecond)
                    {
                        res += str2.charAt(currentPosInSecond);
                        lastPosInSecond = currentPosInSecond;
                    }
                }
                currentPosInFirst++;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.getLCS(STR1, STR2));
    }
}
