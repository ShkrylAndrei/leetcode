package info.shkryl.task70_climbingStairs;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1; // способы для n = 1
        int prev1 = 2; // способы для n = 2

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.climbStairs(6);
        System.out.println(result);
    }
}