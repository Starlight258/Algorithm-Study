import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 해당 info에 대해 가능한 모든 조건에 점수 저장
        Map<String, List<Integer>> infoMap = new HashMap<>();
        for (int i=0;i<info.length;i++){
            String[] split = info[i].split(" ");
            String lang = split[0], part = split[1], career = split[2], food = split[3];
            int score = Integer.parseInt(split[4]);
            
            for (int a=0;a<2;a++){
                for (int b=0;b<2;b++){
                    for (int c=0;c<2;c++){
                        for (int d=0;d<2;d++){
                            StringBuilder sb = new StringBuilder();
                            sb.append(a == 0 ? "-" : lang);
                            sb.append(b == 0 ? "-" : part);
                            sb.append(c == 0 ? "-" : career);
                            sb.append(d == 0 ? "-" : food);
                            String key = sb.toString();
                            infoMap.computeIfAbsent(key, k-> new ArrayList<>()).add(score);
                         }
                    }
                }
            }
        }
        
        // 점수 정렬 (이진탐색을 위함)
        for (List<Integer> list:infoMap.values()){
            Collections.sort(list);
        }
        
        // 쿼리 조건 저장
        String[] querySplit = new String[query.length];
        int[] queryScore = new int[query.length];
        
        for (int i=0;i<query.length;i++){            
            String[] sq = query[i].split(" and ");
            String key = String.join("", sq[0], sq[1], sq[2]);
            String[] subCond = sq[3].split(" ");
            key += subCond[0];
            querySplit[i] = key;
            queryScore[i] = Integer.parseInt(subCond[1]);
        }
        
        // 조건에 해당하는 점수 리스트에 대해 이진 탐색 수행
        for (int i=0;i<query.length;i++){
            List<Integer> list = infoMap.getOrDefault(querySplit[i], new ArrayList<>());
            
            int left = 0;
            int right = list.size();
            
            while (left<right){
                int mid = (left + right) / 2;
                if (list.get(mid) >= queryScore[i]){
                    right = mid;
                } else left = mid + 1;
            }
            
            answer[i] = list.size() - left;
        }
      
        return answer;
    }
}