package info.shkryl.task46_permutations;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, currentPermutation, used, result);
        return result;
    }

    private void backtrack(
            int[] nums,
            List<Integer> currentPermutation,
            boolean[] used,
            List<List<Integer>> result
    ) {
        // Базовый случай: если текущая перестановка полная — добавляем копию в результат
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Пробуем добавить каждый ещё не использованный элемент
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // уже использован — пропускаем

            // Выбираем элемент
            currentPermutation.add(nums[i]);
            used[i] = true;

            // Рекурсивно строим дальше
            backtrack(nums, currentPermutation, used, result);

            // Откатываем выбор (backtrack!)
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(input);
        System.out.println(result);
    }
}
