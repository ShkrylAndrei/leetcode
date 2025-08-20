package info.shkryl.task7_InverseInteger;

public class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;  // Берём последнюю цифру
            x /= 10;             // Убираем последнюю цифру из числа

            // Проверка на переполнение ДО умножения
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;  // "Приклеиваем" цифру
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(123);
        System.out.println(result);
    }
}
