package info.shkryl.task2_addTwoNumbers;

//Вам даны два непустых связанных списка, представляющих два ненулевых целых числа .
// Цифры хранятся в обратном порядке , и каждый узел содержит одну цифру.
// Сложите эти числа и верните сумму как связанный список.
//Example1
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//Example 2:
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Example3
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
public class Solution {

    public static void main(String[] args) {
       ListNode l1 = fillLinkedList(243);
       ListNode l2=fillLinkedList(564);

       Solution solution = new Solution();
       ListNode result = solution.addTwoNumbers(l1,l2);
       //Вывод на экран
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Виртуальная голова для удобства построения нового списка
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0; // Перенос при сложении

        // Проходим по спискам, пока есть цифры
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10; // Новый перенос

            // Добавляем новый узел в результат
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // Если остался перенос после окончания списков
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next; // Возвращаем начало результата
    }

    private static ListNode fillLinkedList(int number) {
        if (number == 0) {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (number > 0) {
            curr.next = new ListNode(number % 10);
            curr = curr.next;
            number /= 10;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    // Конструктор с ссылкой на следующий узел
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
