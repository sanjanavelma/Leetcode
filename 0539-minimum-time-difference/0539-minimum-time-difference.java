import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Convert each time point to minutes and store in an array
        int[] minutes = new int[timePoints.size()];
        
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            minutes[i] = hour * 60 + minute;
        }
        
        // Sort the array of minutes
        Arrays.sort(minutes);
        
        // Initialize the minimum difference with a large value
        int minDiff = Integer.MAX_VALUE;
        
        // Calculate the differences between consecutive time points
        for (int i = 1; i < minutes.length; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        
        // Also check the circular difference between the first and last time points
        int circularDiff = (24 * 60 - minutes[minutes.length - 1]) + minutes[0];
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}
