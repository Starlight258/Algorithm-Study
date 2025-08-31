import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String[] cloth : clothes){
            String name = cloth[0];
            String kind = cloth[1];
            countMap.put(kind, countMap.getOrDefault(kind,0)+1);
        }
        int answer = 1;
        for (int v : countMap.values()){
            answer *= (v+1);
        }
        
        return answer - 1;
    }
    // 옷 -> 입을 수도 있고, 안입을 수도 있음
    // 3 * 2 * 2*2 = 24 -1 = 23
    // Map<String, Integer> 개수 
    // (개수+1)*(개수+1)*.. - 1(모두 안입은 경우)
}