class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        int[][] result = new int[n+1][2];
        while(i < n){
            if(isBefore(newInterval, intervals[i])){
                // no overlapint and the new should be placed before the ith interval
                result[i] = newInterval;
                for(int j=i; j< n; j++){
                    result[j+1] = intervals[j];
                }
                return result;
            }
            if(isBefore(intervals[i], newInterval)){
                //no overlaping and the new is after the ith.
                result[i] = intervals[i];
                i++;
                continue;
            }
            // my start is <= than his end and vice verca
            int j= i;
            int newSize = n+1;
            int[] tmp = newInterval;
            while(j<n && overlap(intervals[j], tmp)){
                System.out.println(Arrays.toString(tmp));
                tmp = mergeOverlaping(tmp, intervals[j]);
                j++;
                newSize--;
            }
            result[i] = tmp;
            if(j<n){
                for(int k=j; k<n; k++){
                    i++;
                    result[i] = intervals[k];
                }
            }
            return Arrays.copyOfRange(result, 0, newSize);
        }

        // the new Intervall is at the end and no overlapping.
        result[n] = newInterval;
        return result;
        

    }

    private int[] mergeOverlaping(int[] interval1, int[] interval2){
        return new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }
    private boolean overlap(int[] interval1, int[] interval2){
        return interval1[0] <= interval2[1] && interval2[0] <= interval1[1];
    }

    private boolean isAfter(int[] interval1, int[] interval2){
        return interval1[0] > interval2[1];
    }

    private boolean isBefore(int[] interval1, int[] interval2){
        return interval1[1] < interval2[0];
    }
}
