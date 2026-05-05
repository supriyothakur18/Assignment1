import java.util.*;

public class CyclicSubstringMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        sc.close();

        System.out.println(maxCyclicSubstringSum(S));
    }

    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();
        String doubled = S + S; 
        int maxSum = 0;
        int currentSum = 0;
        int left = 0;

        
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < doubled.length(); right++) {
            char c = doubled.charAt(right);
            int value = c - 'a' + 1;

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                while (left <= lastSeen.get(c)) {
                    char leftChar = doubled.charAt(left);
                    currentSum -= (leftChar - 'a' + 1);
                    left++;
                }
            }

            currentSum += value;
            lastSeen.put(c, right);

            if (right - left + 1 > n) {
                char leftChar = doubled.charAt(left);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
