class Solution {
    private boolean isPrime(int num) {
        if (num == 2)
            return true;

        int sqrt = (int)Math.ceil(Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private int getLargestPrimeInRange(int end) {
        if (end <= 1)
            return -1;
        while (end > 0) {
            if (isPrime(end))
                return end;
            end--;
        }
        return -1;
    }

    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int prev = i > 0 ? nums[i - 1] : 0;
            int prime = getLargestPrimeInRange(nums[i] - 1 - prev);
    
            if (prime != -1)
                nums[i] -= prime;

            if (i > 0 && nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}