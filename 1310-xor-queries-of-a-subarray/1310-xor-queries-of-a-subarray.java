class Solution {
  public int[] xorQueries(int[] arr, int[][] queries) {
    var n = arr.length;

    for (var i = 1; i < n; i++)
      arr[i] ^= arr[i - 1];

    var m = queries.length;
    var res = new int[m];

    for (var i = 0; i < m; i++)
      res[i] = arr[queries[i][1]] ^ (queries[i][0] > 0 ? arr[queries[i][0] - 1] : 0);
    
    return res;
  }
}