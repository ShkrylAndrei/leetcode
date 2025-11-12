package info.shkryl.task78_subsets;

import java.util.ArrayList;
import java.util.List;

public class SolutionThird {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n; // 2^n

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SolutionThird solution = new SolutionThird();
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
