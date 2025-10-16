package info.shkryl.task31_nextPermutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Шаг 1: Найти самый правый индекс i, где nums[i] < nums[i + 1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Если такого i нет — массив в порядке убывания
        if (i >= 0) {
            // Шаг 2: Найти самый правый j > i, где nums[j] > nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Шаг 3: Поменять местами nums[i] и nums[j]
            swap(nums, i, j);
        }

        // Шаг 4: Перевернуть всё после i (включая случай i = -1 → перевернуть весь массив)
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] in = {1,2,3};
        solution.nextPermutation(in);
        System.out.println(Arrays.toString(in));

    }
}
