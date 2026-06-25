class Solution {
    public int uniquePaths(int m, int n) {
        long a=1;
        int b=m+n-2;
        int r=Math.min(m-1,n-1);
        for(int i=1;i<=r;i++) {
            a=a*(b-r+i)/i;
        }
        return (int)a;
    }
}