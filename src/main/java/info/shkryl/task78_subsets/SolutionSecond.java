package info.shkryl.task78_subsets;

import java.util.ArrayList;
import java.util.List;

public class SolutionSecond {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // начинаем с пустого подмножества

        for (int num : nums) {
            int size = result.size();
            // Копируем все существующие подмножества и добавляем к ним `num`
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SolutionSecond solution = new SolutionSecond();
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
