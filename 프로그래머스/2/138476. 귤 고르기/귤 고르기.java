import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 종류별 개수 세기
        Map<Integer, Integer> mp = new HashMap<>();
        for (int t:tangerine){
            mp.put(t, mp.getOrDefault(t, 0) + 1);
        }
        // 개수별 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(mp.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        // 귤 담기
        for (Map.Entry<Integer, Integer> e : entryList){
            k -= e.getValue();
            answer++;
            if (k<=0) break;
        }

        return answer;
    }
}