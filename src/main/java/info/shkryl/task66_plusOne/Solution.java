package info.shkryl.task66_plusOne;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Проходим по массиву справа налево
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // Нет переноса — просто увеличиваем и выходим
                digits[i]++;
                return digits;
            }
            // Если цифра == 9 → она становится 0, и перенос продолжается
            digits[i] = 0;
        }

        // Если мы дошли сюда — было число вида 999...9
        // Нужен новый массив на 1 элемент длиннее
        int[] result = new int[n + 1];
        result[0] = 1; // остальные элементы по умолчанию 0
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        Solution solution = new Solution();
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
