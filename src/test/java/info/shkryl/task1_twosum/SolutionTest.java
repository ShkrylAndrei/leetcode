package info.shkryl.task1_twosum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testTwoSum_CaseFirst() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 0};

        assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    void testTwoSum_CaseSecond() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {2, 1};

        assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    void testTwoSum_CaseThird() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {1, 0};

        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
}