import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> name = new HashMap<>();
        Set<String> reportSet = new HashSet<>();
        Map<Integer, List<Integer>> reportIdx = new HashMap<>();
        for (int i=0;i<id_list.length;i++){
            name.put(id_list[i], i);
            reportIdx.computeIfAbsent(i, l->new ArrayList<>());
        }
        for (String rp:report){
            reportSet.add(rp);
        }
        for (String rp:reportSet){
            String[] split = rp.split(" ");
            String from = split[0];
            String to = split[1];
            reportIdx.get(name.get(to)).add(name.get(from));
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