package info.shkryl.task35_searchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Защита от переполнения

            if (nums[mid] == target) {
                return mid; // Нашли точное совпадение
            } else if (nums[mid] < target) {
                left = mid + 1; // Ищем справа
            } else {
                right = mid - 1; // Ищем слева
            }
        }

        // Если не нашли — left указывает на позицию для вставки
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,3,5,6};
        int target = 5;
        int result = solution.searchInsert(input, target);
        System.out.println(result);
    }
}
