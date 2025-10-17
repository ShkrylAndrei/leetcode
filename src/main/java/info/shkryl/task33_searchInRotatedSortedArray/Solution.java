package info.shkryl.task33_searchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Защита от переполнения

            if (nums[mid] == target) {
                return mid;
            }

            // Левая половина отсортирована?
            if (nums[left] <= nums[mid]) {
                // Проверяем, попадает ли target в отсортированную левую часть
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Ищем слева
                } else {
                    left = mid + 1;  // Ищем справа
                }
            } else {
                // Правая половина отсортирована
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Ищем справа
                } else {
                    right = mid - 1; // Ищем слева
                }
            }
        }

        return -1; // Не найдено
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {4,5,6,7,0,1,2};
        int target = 0;
        int result = solution.search(input,target);
        System.out.println(result);
    }
}
