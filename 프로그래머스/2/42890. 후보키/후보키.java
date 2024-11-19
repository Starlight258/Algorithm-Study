import java.util.*;

class Solution {
    public int solution(String[][] relations) {
        int answer = 0;
        // key 만들기
        List<List<Integer>> keys = makeKeys(relations[0].length);

        // 개수 세기
        List<List<Integer>> realKeys = new ArrayList<>();
        for (List<Integer> key:keys){
            boolean isValid = true;
            for (List<Integer> realKey:realKeys){
                if (key.containsAll(realKey)){
                    isValid = false;
                    break;
                }
            }
            if (!isValid) continue;
            Set<String> combination = new HashSet<>();
            for (String[] relation:relations){
                String temp = "";
                for (Integer k:key){
                    temp += relation[k];
                }
                combination.add(temp);
            }
            if (combination.size()==relations.length){
                realKeys.add(key);
                answer++;
            }
        }
        return answer;
    }
    private List<List<Integer>> makeKeys(int n){
        List<List<Integer>> keys = new ArrayList<>();
        List<Integer> key = new ArrayList<>();
        for (int i=0;i<n;i++){
            key.add(i);
        }
        boolean visited[] = new boolean[n];
        for (int i=0;i<key.size();i++){
            combination(keys, key, visited, 0, 0, i+1);
        }
        
        return keys;
    }
    private void combination(List<List<Integer>> keys, List<Integer> key, boolean[] visited, int start, int depth, int r){
        if (depth==r){
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<key.size();i++){
                if (visited[i]) temp.add(key.get(i));
            }
            keys.add(temp);
            return;
        }
        for (int i=start;i<key.size();i++){
            if (!visited[i]){
                visited[i] = true;
                combination(keys, key, visited, start+1, depth+1, r);
                visited[i] = false;
            }
        }
    }
}