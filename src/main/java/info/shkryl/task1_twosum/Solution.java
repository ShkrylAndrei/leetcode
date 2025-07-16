package info.shkryl.task1_twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Условие задачи
//1. Сумма двух
//Дан массив целых чисел nums и целое число target,
// вернуть индексы двух чисел так, чтобы их сумма давала target
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //случай 1
        int[] numsCase1 = {2,7,11,15};
        int target = 9;
        int[] result = solution.twoSum(numsCase1,target);
        System.out.println("Результат случая 1: "+ Arrays.toString(result));

        //случай 2
        int[] numsCase2 = {3,2,4};
        target = 6;
        result = solution.twoSum(numsCase2,target);
        System.out.println("Результат случая 2: "+ Arrays.toString(result));

        //случай 3
        int[] numsCase3 = {3,3};
        target = 6;
        result = solution.twoSum(numsCase3,target);
        System.out.println("Результат случая 3: "+ Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target) {

        //Первый элемент число, второй индекс в массиве nums
        Map<Integer,Integer> container = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(target-nums[i])){
                return new int[]{i, container.get(target-nums[i])};
            }else{
                container.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}


