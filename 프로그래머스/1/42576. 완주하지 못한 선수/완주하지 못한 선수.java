import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mp = new HashMap<>();
        for (String p:participant){
            mp.put(p, mp.getOrDefault(p, 0)+1);
        }
        for (String c:completion){
            int count = mp.get(c);
            if (count==1){
                mp.remove(c);
            } else {
                mp.put(c, count-1);
            }
        }
        List<String> remains = new ArrayList<>(mp.keySet());
        return remains.get(0);
    }
    
    // Map<String, Integer> 
    // 완주한 경우 -1, 마지막 동명이인 선수일 경우 remove
    // -> map을 순회하며 남은 key가 존재할 경우 return
}