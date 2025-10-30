package info.shkryl.task53_maximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        // Текущая сумма подмассива, заканчивающегося на текущем элементе
        int currentSum = nums[0];
        // Максимальная сумма среди всех подмассивов
        int maxSum = nums[0];

        // Проходим по массиву, начиная со второго элемента
        for (int i = 1; i < nums.length; i++) {
            // Решаем: продолжить предыдущий подмассив или начать новый?
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Обновляем глобальный максимум
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int result = solution.maxSubArray(input);
        System.out.println(result);
    }
}
