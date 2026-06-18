class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int n=nums.length;
       int r[]=new int[n];
       for(int i=0;i<n;i++){
        r[i]=-1;
      for(int j=0;j<n;j++){
        int idx=(i+j)%n;
        if(nums[idx]>nums[i]){
        r[i]=nums[idx];
        break;
        }
      }
       }
       return r;
    }
    }