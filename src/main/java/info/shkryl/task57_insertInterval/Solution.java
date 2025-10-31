package info.shkryl.task57_insertInterval;

import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Добавляем все интервалы, которые заканчиваются ДО начала newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Объединяем все пересекающиеся интервалы с newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Расширяем границы newInterval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Добавляем объединённый интервал
        result.add(newInterval);

        // 3. Добавляем все интервалы, которые начинаются ПОСЛЕ окончания newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] input={{1,3},{6,9}};
        int[]  newInterval = {2,5};
        Solution solution = new Solution();
        int[][] result = solution.insert(input,newInterval);
        System.out.println(Arrays.deepToString(result));
    }
}
