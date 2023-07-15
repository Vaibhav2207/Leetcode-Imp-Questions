/*
 
You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

i < j < k,
nums[j] - nums[i] == diff, and
nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.

 

Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3. */
class Solution {
    public int isThere(int nums[], int key, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        // int n = nums.length;
        // int res = 0;
        // for(int i=0;i<n;i++){
        // int key = diff + nums[i];
        // int j = isThere(nums,key,i+1,n-1);
        // if(j != -1){
        // int k = isThere(nums,nums[j]+diff,j+1,n-1);
        // if(k != -1){
        // res++;
        // }
        // }
        // }
        // return res;

        int n = nums.length;
        int res = 0;
        int arr[] = new int[201];
        for (int i : nums) {
            arr[i]++;
        }
        for (int i : nums) {
            int second = i + diff;
            if (second < 201 && arr[second] == 0)
                continue;
            int third = second + diff;
            if (third < 201 && arr[third] != 0)
                res++;
        }
        return res;
    }
}
