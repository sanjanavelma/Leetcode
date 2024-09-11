class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Base case: if the string is empty, return 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Use a sliding window technique
        int left = 0, right = 0, maxLength = 0;
        // A hash set to track characters in the current window
        Set<Character> uniqueChars = new HashSet<>();

        // Loop through the string with the right pointer
        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If the character is not in the set, add it and expand the window
            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                // If the character is in the set, remove the leftmost character and shrink the window
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}