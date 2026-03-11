package info.shkryl.task94_binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class SolutionSecond {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // Пока есть что обрабатывать
        while (current != null || !stack.isEmpty()) {

            // 1 Идём максимально влево, складывая узлы в стек
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2 Достаем узел из стека — это следующий для записи
            current = stack.pop();
            result.add(current.val);

            // 3 Переходим к правому ребёнку
            current = current.right;
        }
        return result;
    }
}
