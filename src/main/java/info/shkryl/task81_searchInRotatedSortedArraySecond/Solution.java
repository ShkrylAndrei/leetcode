package info.shkryl.task81_searchInRotatedSortedArraySecond;

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Случай неоднозначности: все три значения равны
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                // Сужаем границы, чтобы убрать дубликаты
                left++;
                right--;
            }
            // Левая половина отсортирована
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target в левой половине
                } else {
                    left = mid + 1; // иначе — в правой
                }
            }
            // Правая половина отсортирована
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target в правой половине
                } else {
                    right = mid - 1; // иначе — в левой
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] input = {1,0,1,1,1};
        int target = 1;
        Solution solution = new Solution();
        boolean result = solution.search(input, target);
        System.out.println(result);
    }
}
