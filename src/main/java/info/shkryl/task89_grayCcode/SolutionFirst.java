package info.shkryl.task89_grayCcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionFirst {
    public List<Integer> grayCode(int n) {
        if (n == 0) return new ArrayList<>(Collections.singletonList(0));

        List<Integer> prev = grayCode(n - 1);
        List<Integer> result = new ArrayList<>(prev);

        // Добавляем зеркальную часть с установленным старшим битом
        int add = 1 << (n - 1); // 2^(n-1)
        for (int i = prev.size() - 1; i >= 0; i--) {
            result.add(prev.get(i) + add);
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionFirst solution = new SolutionFirst();
        List<Integer> result = solution.grayCode(2);
        System.out.println(result);
    }
}
