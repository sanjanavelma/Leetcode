class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length(), m = target.length();
        while (i < n && j < m) {
            char a = start.charAt(i);
            char b = target.charAt(j);
            if (a == '_' && b == '_') {
                i++;
                j++;
            } 
            else if (a == '_') {
                i++;
            } 
            else if (b == '_') {
                j++;
            } 
            else if (
                a == b && 
                (
                    (a == 'L' && i >= j) || // 'L' can only move left
                    (a == 'R' && i <= j)    // 'R' can only move right
                )
            ) {
                i++;
                j++;
            } 
            else {
                return false;
            }
        }
        while (i < n && start.charAt(i) == '_') {
            i++;
        }
        while (j < m && target.charAt(j) == '_') {
            j++;
        }
        return i == n && j == m;
    }
}

