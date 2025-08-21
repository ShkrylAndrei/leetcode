package info.shkryl.task8_stringToIntegerAtoi;

public class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;
        int n = s.length();

        // Шаг 1: Пропускаем пробелы
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Шаг 2: Проверяем знак
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Шаг 3: Собираем цифры
        while (index < n) {
            char c = s.charAt(index);

            // Если не цифра — останавливаемся
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';  // Превращаем символ в цифру

            // Шаг 4: Проверка переполнения ДО умножения
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Собираем число: result = result * 10 + digit
            result = result * 10 + digit;
            index++;
        }

        // Шаг 5: Применяем знак
        return result * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi(" -042");
        System.out.println(result);
    }
}
