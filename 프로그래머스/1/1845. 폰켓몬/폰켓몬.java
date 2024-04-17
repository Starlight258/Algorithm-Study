import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n:nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        int n = nums.length;
        if (hm.size() >= n / 2) return n / 2;
        else return hm.size();
    }
}