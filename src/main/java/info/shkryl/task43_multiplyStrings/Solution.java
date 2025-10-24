package info.shkryl.task43_multiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        // Особый случай: если одно из чисел — ноль
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();
        int[] pos = new int[n + m]; // Максимум n + m цифр

        // Проходим по каждой цифре справа налево
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;
                int p1 = i + j;         // Позиция для переноса (десятки)
                int p2 = i + j + 1;     // Позиция для текущей цифры (единицы)

                // Добавляем произведение к текущей позиции
                int sum = product + pos[p2];

                pos[p2] = sum % 10;     // Оставляем только единицы
                pos[p1] += sum / 10;    // Переносим десятки
            }
        }

        // Собираем результат в строку, пропуская ведущие нули
        StringBuilder sb = new StringBuilder();
        for (int digit : pos) {
            // Пропускаем нули в начале, но не все (если результат "0")
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String firstNumber = "999";
        String secondNumber= "543";
        Solution solution = new Solution();
        String result = solution.multiply(firstNumber, secondNumber);
        System.out.println(result);
    }
}
