import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, List<Integer>> reportIdx = new HashMap<>();
        for (int i=0;i<id_list.length;i++){
            name.put(id_list[i], i);
            reportIdx.computeIfAbsent(i, l->new ArrayList<>());
        }
        for (String rp:report){
            String[] split = rp.split(" ");
            String from = split[0];
            String to = split[1];
            if (!reportIdx.get(name.get(to)).contains(name.get(from))){
                reportIdx.get(name.get(to)).add(name.get(from));
            }
        }
        // 메일 횟수
        int[] mail = new int[id_list.length];
        for (Map.Entry<Integer, List<Integer>> ri:reportIdx.entrySet()){
            if (ri.getValue().size()<k){
                continue;
            }
            for (Integer r:ri.getValue()){
                mail[r]++;
            }
        }
        return mail;
    }
}