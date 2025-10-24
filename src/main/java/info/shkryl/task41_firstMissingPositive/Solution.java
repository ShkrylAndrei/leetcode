package info.shkryl.task41_firstMissingPositive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Шаг 1: Заменяем все неподходящие числа на (n + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Шаг 2: Используем знак как флаг присутствия числа
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // Важно: брать модуль!
            if (num <= n) {
                // Делаем число по индексу (num - 1) отрицательным
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Шаг 3: Находим первый положительный элемент
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // Потому что индекс i соответствует числу i+1
            }
        }

        // Если все числа от 1 до n есть — ответ n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] input = {1,2,0};
        Solution solution = new Solution();
        int result = solution.firstMissingPositive(input);
        System.out.println(result);
    }
}
