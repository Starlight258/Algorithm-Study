class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] nums = new int[n];
        for (int i=0;i<lost.length;i++){
            nums[lost[i]-1]--; 
        }
        for (int i=0;i<reserve.length;i++){
            nums[reserve[i]-1]++;
        }
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                if (i-1>=0 && nums[i-1]<0){
                    nums[i-1]=0;
                    nums[i]=0;
                }
                else if (i+1<n&& nums[i+1]<0){
                    nums[i+1]=0;
                    nums[i]=0;
                }
            }
        }
        int lostNum = 0;
        for (int i=0;i<n;i++){
            if (nums[i]<0) lostNum++;
        }
        return n - lostNum;
    }
}