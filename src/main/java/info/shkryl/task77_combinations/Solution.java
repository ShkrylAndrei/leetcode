package info.shkryl.task77_combinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(1, n, k, current, result);
        return result;
    }

    private void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result
    ) {
        // Базовый случай: комбинация заполнена
        if (current.size() == k) {
            result.add(new ArrayList<>(current)); // сохраняем копию
            return;
        }

        // Пробуем добавить каждое число от start до n
        for (int i = start; i <= n; i++) {
            current.add(i);                   // выбираем
            backtrack(i + 1, n, k, current, result); // рекурсия
            current.remove(current.size() - 1); // откатываем (backtrack)
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(n, k);
        System.out.println(result);
    }
}
