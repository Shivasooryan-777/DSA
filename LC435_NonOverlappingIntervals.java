import java.util.Arrays;

public class LC435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int countRemoved = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap detected: remove this interval (keep the one ending earlier)
                countRemoved++;
            } else {
                // Non-overlapping: update prevEnd
                prevEnd = intervals[i][1];
            }
        }

        return countRemoved;
    }
}
