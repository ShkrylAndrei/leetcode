package info.shkryl.task75_sortColors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // 0 → перемещаем в начало
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 → оставляем на месте, просто двигаемся дальше
                mid++;
            } else { // nums[mid] == 2
                // 2 → перемещаем в конец
                swap(nums, mid, high);
                high--;
                // mid НЕ увеличиваем, потому что элемент с high может быть 0 или 1
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
