package hackerrank;

/**
 * Created by BudaiK on Mar, 2020.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        int n = s.length();
        if (n ==0 || n == 1) {
            return true;
        }
        int i =0;
        int j = n-1;
        while(i <j) {
            // skip non letters from beggining:
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j) && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
