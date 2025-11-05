package info.shkryl.task71_simplifyPath;

import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        // Разбиваем путь на компоненты по символу '/'
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>(); // или Stack<String>, но Deque предпочтительнее

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                // Игнорируем пустые компоненты (от "///") и текущую директорию "."
                continue;
            } else if (part.equals("..")) {
                // Возврат на уровень выше — убираем последнюю директорию из стека
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Обычное имя — добавляем в стек
                stack.push(part);
            }
        }

        // Если стек пуст — возвращаем корень
        if (stack.isEmpty()) {
            return "/";
        }

        // Собираем путь в правильном порядке (от дна стека к вершине)
        // Поскольку Deque при pop() возвращает в обратном порядке,
        // мы можем использовать toArray и перебрать с конца
        String[] resultParts = stack.toArray(new String[0]);
        StringBuilder sb = new StringBuilder();
        // Обходим массив в обратном порядке (т.к. push кладёт в начало)
        for (int i = resultParts.length - 1; i >= 0; i--) {
            sb.append("/").append(resultParts[i]);
        }

        return sb.toString();
    }
}
