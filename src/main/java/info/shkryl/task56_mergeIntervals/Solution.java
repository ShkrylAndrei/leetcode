package info.shkryl.task56_mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Сортируем интервалы по начальной точке
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // Если список пуст или текущий интервал не пересекается с последним в списке
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Объединяем: расширяем конец последнего интервала
                merged.get(merged.size() - 1)[1] = Math.max(
                        merged.get(merged.size() - 1)[1],
                        interval[1]
                );
            }
        }

        // Преобразуем список в массив
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        int[][] result = solution.merge(input);
        System.out.println(Arrays.deepToString(result));
    }
}
