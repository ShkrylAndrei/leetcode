package info.shkryl.task78_subsets;

import java.util.ArrayList;
import java.util.List;

public class SolutionFirst {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);
        return result;
    }

    private void backtrack(
            int index,
            int[] nums,
            List<Integer> current,
            List<List<Integer>> result
    ) {
        // Важно: добавляем КОПИЮ текущего подмножества на КАЖДОМ шаге
        result.add(new ArrayList<>(current));

        // Пробуем добавить каждый элемент, начиная с `index`
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);          // выбираем
            backtrack(i + 1, nums, current, result); // рекурсия
            current.remove(current.size() - 1); // откат (backtrack)
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SolutionFirst solution = new SolutionFirst();
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
