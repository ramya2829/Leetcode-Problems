class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(p1,p2)->{
            int d1=p1[0]*p1[0]+p1[1]*p1[1];
            int d2=p2[0]*p2[0]+p2[1]*p2[1];
            return Integer.compare(d1, d2);
        });
        
        return Arrays.copyOfRange(points, 0, k);
    }
}