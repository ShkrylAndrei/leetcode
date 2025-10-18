package info.shkryl.task34findFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1}; // Если нет первого — нет и последнего
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;       // Запоминаем позицию
                right = mid - 1;    // И продолжаем искать ВЛЕВО
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;       // Запоминаем позицию
                left = mid + 1;     // И продолжаем искать ВПРАВО
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {5,7,7,8,8,10};
        int target = 8;
        int[] result = solution.searchRange(input,target);
        System.out.println(Arrays.toString(result));
    }
}
