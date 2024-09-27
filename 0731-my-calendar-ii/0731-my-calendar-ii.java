import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if this event would cause a triple booking
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false; // Triple booking detected
            }
        }

        // Add the overlaps to the overlap list
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                // Add the overlap between this booking and the new event
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
            }
        }

        // Add this event to the booking list
        bookings.add(new int[]{start, end});
        return true;
    }
}
