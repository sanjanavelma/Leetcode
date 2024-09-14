public class Solution {
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // Step 2: Find the length of the longest contiguous subarray with all elements equal to maxVal
        int longest = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                if (currentLength > longest) {
                    longest = currentLength;
                }
            } else {
                currentLength = 0;
            }
        }
        
        return longest;
    }
}
