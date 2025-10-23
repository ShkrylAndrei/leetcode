package info.shkryl.task40_combinationSumSecond;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Сортируем для обработки дубликатов
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
            int[] candidates,
            int remainingTarget,
            int startIndex,
            List<Integer> currentCombination,
            List<List<Integer>> result
    ) {
        // Базовый случай: если остаток = 0 — нашли комбинацию
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Перебираем элементы начиная с startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            // Пропускаем, если текущее число больше остатка — дальше нет смысла
            if (candidates[i] > remainingTarget) {
                break;
            }

            // Пропускаем дубликаты: если текущий элемент равен предыдущему,
            // и предыдущий НЕ был использован в этой ветке (i > startIndex),
            // то пропускаем, чтобы избежать повторных комбинаций
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Выбираем текущий элемент
            currentCombination.add(candidates[i]);

            // Рекурсивно ищем остаток, начиная со следующего индекса (i + 1),
            // потому что каждый элемент можно использовать только один раз
            backtrack(candidates, remainingTarget - candidates[i], i + 1, currentCombination, result);

            // Отменяем выбор (backtrack)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum2(input, target);
        System.out.println(result);
    }
}
