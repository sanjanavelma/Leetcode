public class Solution {
    
    private List<Integer> getBin(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            if ((n & 1) == 1) {
                res.add(1);
            } else {
                res.add(0);
            }
            n >>= 1;
        }
        return res;
    }

    public long minEnd(int n, int x) {
        if (n == 1) return x;
        List<Integer> zeroPos = new ArrayList<>();
        int count = 0;
        int val = x;
        while (val > 0) {
            if ((val & 1) == 0) {
                zeroPos.add(count);
            }
            count++;
            val >>= 1;
        }

        int reqdBits = (int) Math.ceil(Math.log(n) / Math.log(2));

        for (int i = zeroPos.size(); i < reqdBits; i++) {
            zeroPos.add(count++);
        }
        List<Integer> appendBits = getBin(n - 1);
        long ans = x;
        int pos = appendBits.size();
        while (pos-- > 0) {
            if (appendBits.get(pos) == 1) {
                ans += (1L << zeroPos.get(pos));
            }
        }

        return ans;
    }
}