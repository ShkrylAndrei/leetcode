package info.shkryl.task20_validParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Проверяет, правильно ли расставлены скобки в строке.
     * Используется стек для отслеживания открывающих скобок.
     *
     * @param s строка, содержащая только '(', ')', '{', '}', '[', ']'
     * @return true, если скобки сбалансированы, иначе false
     */
    public boolean isValid(String s) {
        // Создаём стек для хранения открывающих скобок
        Deque<Character> stack = new ArrayDeque<>(); // ArrayDeque — быстрее и современнее Stack

        // Проходим по каждому символу строки
        for (char c : s.toCharArray()) {
            // Если символ — открывающая скобка, кладём в стек
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Если символ — закрывающая скобка
            else if (c == ')' || c == '}' || c == ']') {
                // Если стек пуст — нет парной открывающей → невалидно
                if (stack.isEmpty()) {
                    return false;
                }

                // Достаём последнюю открывающую скобку
                char top = stack.pop();

                // Проверяем соответствие
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
            // По условию других символов нет, но можно добавить else для расширения
        }

        // Если стек пуст — все скобки закрыты правильно
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "()[]{}";
        boolean output = solution.isValid(input);
        System.out.println(output);
    }
}
