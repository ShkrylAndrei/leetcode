package info.shkryl.task93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // Оптимизация: IP не может быть длиннее 12 цифр (4 части по 3 цифры)
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }

        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param s исходная строка
     * @param start индекс, с которого начинаем брать цифры
     * @param dots сколько частей уже собрали (0..4)
     * @param current текущие части IP-адреса
     * @param result список ответов
     */
    private void backtrack(String s, int start, int dots,
                           List<String> current, List<String> result) {

        // База: собрали 4 части и использовали все цифры
        if (dots == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }

        //Слишком много частей или вышли за пределы строки
        if (dots == 4 || start == s.length()) {
            return;
        }

        // Пробуем взять 1, 2 или 3 цифры для текущей части
        for (int len = 1; len <= 3; len++) {
            // Не выходим за границы строки
            if (start + len > s.length()) break;

            String part = s.substring(start, start + len);

            // Проверяем валидность части
            if (isValid(part)) {
                current.add(part);  // Выбираем
                backtrack(s, start + len, dots + 1, current, result);  // Исследуем
                current.remove(current.size() - 1);  // Откат (бэктрекинг!)
            }
        }
    }

    /**
     * Проверяет, валидна ли часть IP-адреса
     */
    private boolean isValid(String part) {
        //Ведущий ноль в многозначном числе: "01", "001"
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        // Проверяем диапазон 0..255
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("25525511135");
        System.out.println(result);
    }
}
