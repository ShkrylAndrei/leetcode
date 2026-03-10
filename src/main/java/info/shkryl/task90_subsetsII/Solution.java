package info.shkryl.task90_subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //  Сортируем! Без этого не отсечь дубликаты
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current,
                           int[] nums, int start) {
        // Добавляем текущий набор в результат (копию!)
        result.add(new ArrayList<>(current));

        // Пробуем добавить каждую следующую конфету
        for (int i = start; i < nums.length; i++) {
            // ГЛАВНОЕ ПРАВИЛО: пропускаем дубликаты на одном уровне!
            if (i > start && nums[i] == nums[i-1]) {
                continue; // Пропускаем эту ветку
            }
            // Выбираем конфету
            current.add(nums[i]);
            // Рекурсивно идём дальше (следующие конфеты)
            backtrack(result, current, nums, i + 1);
            // Отменяем выбор (бэктрекинг)
            current.remove(current.size() - 1);
        }
    }
}
