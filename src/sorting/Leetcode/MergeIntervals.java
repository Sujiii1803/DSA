package sorting.Leetcode;

import java.util.*;

public class MergeIntervals {
        public int[][] merge(int[][] intervals) {
            Arrays.sort( intervals, (a,b) -> Integer.compare( a[0], b[0] ));
            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);
            for( int i = 1; i < intervals.length; i++ ){
                int[] last = list.get( list.size() - 1 );
                int[] current = intervals[i];

                if( current[0] <= last[1] ){
                    last[1] = Math.max( current[1], last[1] );
                }
                else{
                    list.add( current );
                }
            }
            return list.toArray( new int[list.size()][]);
        }
}
