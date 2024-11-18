import java.util.*;

class Solution {
    public int[] solution(String[] infos, String[] queries) {
        List<Integer> answers = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String info: infos){
            String[] split = info.split(" ");
            makeAllCases(0, "", split, map);
        }
         for (Map.Entry<String, List<Integer>> entry:map.entrySet()){
            Collections.sort(entry.getValue());
        }
        // score 개수구하기
        for (String query:queries){
            query = query.replaceAll(" and ", " ");
            String[] split = query.split(" ");
            String key = (split[0]+split[1]+split[2]+split[3]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int number = list.size() - findScores(list, Integer.parseInt(split[4]));
            answers.add(number);
        }
        return answers.stream().mapToInt(x->x).toArray();
    }
    
    private int findScores(List<Integer> scores, int score){
         int left = 0, right = scores.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private void makeAllCases(int depth, String key, String[] split, Map<String, List<Integer>> map){
        if (depth==4){
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(Integer.parseInt(split[4]));
            return;
        }
        
        makeAllCases(depth+1, key + split[depth], split, map);
        makeAllCases(depth+1, key+"-", split, map);
    }
    
}