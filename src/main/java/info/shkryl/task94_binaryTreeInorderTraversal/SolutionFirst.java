package info.shkryl.task94_binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;


public class SolutionFirst {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);  // Запускаем рекурсию
        return result;
    }

    /**
     * Рекурсивная функция inorder-обхода
     * @param node текущий узел
     * @param result список, куда записываем значения
     */
    private void inorder(TreeNode node, List<Integer> result) {
        // База рекурсии: если узел пустой — ничего не делаем
        if (node == null) {
            return;
        }

        // Сначала идём в левое поддерево
        inorder(node.left, result);

        // Записываем значение текущего узла
        result.add(node.val);

        //Потом идём в правое поддерево
        inorder(node.right, result);
    }
}
