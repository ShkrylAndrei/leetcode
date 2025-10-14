package info.shkryl.task29_divideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        // Особый случай: переполнение
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Определяем знак результата
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Переводим оба числа в отрицательные, чтобы избежать переполнения
        int dividendNeg = dividend > 0 ? -dividend : dividend;
        int divisorNeg = divisor > 0 ? -divisor : divisor;

        int quotient = 0;

        // Пока делимое "меньше или равно" делителю (в отрицательных числах!)
        while (dividendNeg <= divisorNeg) {
            int power = 1;
            int value = divisorNeg;

            // Удваиваем делитель, пока возможно (остаёмся в рамках dividendNeg)
            // value >= (Integer.MIN_VALUE >> 1) — защита от переполнения при сдвиге
            while (value >= (Integer.MIN_VALUE >> 1) && dividendNeg <= (value << 1)) {
                value <<= 1;      // value *= 2
                power <<= 1;      // power *= 2
            }

            // Вычитаем найденное максимальное значение
            dividendNeg -= value;
            quotient += power;
        }

        // Применяем знак
        return negative ? -quotient : quotient;
    }
}
