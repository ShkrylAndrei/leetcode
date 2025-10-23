package info.shkryl.task39_combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        // Сортировка не обязательна, но может помочь для раннего выхода
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(
            int[] candidates,
            int remainingTarget,
            int startIndex,
            List<Integer> currentCombination,
            List<List<Integer>> result) {

        // Базовый случай: если остаток = 0 → нашли решение
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination)); // копируем!
            return;
        }

        // Перебираем кандидатов, начиная с startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            // Если текущее число больше остатка — дальше нет смысла (все числа положительные!)
            if (candidates[i] > remainingTarget) {
                break;
            }

            // Выбираем: добавляем число в комбинацию
            currentCombination.add(candidates[i]);

            // Рекурсивно ищем дальше, НЕ увеличивая индекс (можно использовать число снова!)
            backtrack(candidates, remainingTarget - candidates[i], i, currentCombination, result);

            // Откатываем: убираем число из комбинации (важно для backtracking!)
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(input, target);
        System.out.println(result);
    }
}
