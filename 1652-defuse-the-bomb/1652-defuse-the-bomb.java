class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = code[i];
            extended[i + n] = code[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += extended[i + j];
                }
            } else if (k < 0) {
                for (int j = -1; j >= k; j--) {
                    sum += extended[i + n + j];
                }
            }
            result[i] = sum;
        }
        return result;
    }
}