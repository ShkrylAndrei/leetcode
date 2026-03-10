package info.shkryl.task89_grayCcode;

import java.util.ArrayList;
import java.util.List;

class SolutionSecond {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        // Генерируем все числа от 0 до 2ⁿ-1
        for (int i = 0; i < (1 << n); i++) {
            // Магическая формула: i XOR (i сдвинутый вправо)
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionSecond solution = new SolutionSecond();
        List<Integer> result = solution.grayCode(2);
        System.out.println(result);
    }
}
