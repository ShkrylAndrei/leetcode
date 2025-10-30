package info.shkryl.task55_jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0; // Наибольший индекс, до которого мы можем добраться

        for (int i = 0; i < n; i++) {
            // Если текущая позиция недостижима — выходим
            if (i > maxReach) {
                return false;
            }

            // Обновляем максимальную досягаемость
            maxReach = Math.max(maxReach, i + nums[i]);

            // Если уже можем достичь конца — завершаем досрочно
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return true; // На случай, если массив из одного элемента
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        Solution solution = new Solution();
        boolean result = solution.canJump(input);
        System.out.println(result);
    }
}
