/*
 Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
class Solution {

    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        int i = 0, j = 1;
        while (j < n) {
            if (nums[i] == nums[j]) {
                count++;
            } else {
                i = j;
                res += ((count * (count - 1)) / 2);
                count = 1;
            }
            j++;
        }
        return res += ((count * (count - 1)) / 2);
    }
}