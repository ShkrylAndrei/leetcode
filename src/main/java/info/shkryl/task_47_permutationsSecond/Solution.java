package info.shkryl.task_47_permutationsSecond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        // Сортируем, чтобы одинаковые элементы стояли рядом
        Arrays.sort(nums);

        backtrack(nums, current, used, result);
        return result;
    }

    private void backtrack(
            int[] nums,
            List<Integer> current,
            boolean[] used,
            List<List<Integer>> result
    ) {
        // Базовый случай: перестановка готова
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Пропускаем, если элемент уже использован
            if (used[i]) continue;

            // Пропускаем дубликат: если текущий == предыдущий И предыдущий НЕ использован
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Выбираем элемент
            current.add(nums[i]);
            used[i] = true;

            // Рекурсивный вызов
            backtrack(nums, current, used, result);

            // Откат (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permuteUnique(input);
        System.out.println(result);
    }
}
