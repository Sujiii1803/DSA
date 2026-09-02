package Queue.Leetcode;

import java.util.PriorityQueue;

class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> distance(b) - distance(a)
        );
        for( int[] p : points ){
            pq.offer(p);
            if( pq.size() > k ){
                pq.poll();
            }
        }
        int[][] arr = new int[k][2];
        int i = 0;
        while( !pq.isEmpty() ){
            arr[i] = pq.poll();
            i++;
        }
        return arr;
    }
    public int distance( int[] arr ){
        int x = arr[0];
        int y = arr[1];

        int distance = x * x + y * y;

        return distance;
    }
}
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1,2},{3,4},{5,6}};
        KClosestPoints obj = new KClosestPoints();
        int[][] ans = obj.kClosest(points, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("[" + ans[i][0] + ", " + ans[i][1] + "]");
        }
        System.out.print("\n");
    }
}
