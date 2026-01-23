class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> h1=new HashSet<>();
        if(nums[0]+nums[1]+nums[2]>0){
            return ans;
        }
        for (int i = 0; i < len-1; i++) { 
            int l=i+1;
            int h=len-1;
            while(l<h){
                int sum=nums[i]+nums[l]+nums[h];
                if(sum==0){
                        List<Integer> ans1 = new ArrayList<>();
                        ans1.add(nums[i]);
                        ans1.add(nums[l]);
                        ans1.add(nums[h]);
                        h1.add(ans1);
                        int f=nums[l];
                        int s= nums[h];
                        while(l<h && f==nums[l]){
                            l++;
                        }while(h>l && s==nums[h]){
                            h--;
                        }
                        }
                    else if(sum<0){
                        l++;
                    }else{
                        h--;
                    }
                    }
                }
            for(var it:h1){
                ans.add(it);
            }
         return ans;
    }
}
    