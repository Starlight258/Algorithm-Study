class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key : number, value : index
        Map<Integer, Integer> map = new HashMap<>(); // O(N)
        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            System.out.println(i +"," + complement);
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
