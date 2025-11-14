package info.shkryl.task80_removeDuplicatesFromSortedArraySecond;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        // Указатель на позицию для записи
        int i = 2;

        // Начинаем с третьего элемента (индекс 2)
        for (int j = 2; j < nums.length; j++) {
            // Проверяем: не будет ли это третьей копией?
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
            // Если nums[j] == nums[i-2] — пропускаем (третья копия)
        }

        return i;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        Solution solution = new Solution();
        int result = solution.removeDuplicates(input);
        System.out.println(result);
    }
}
