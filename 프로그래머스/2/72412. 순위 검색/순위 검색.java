import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        // int[] score = new int[info.length];
        
        Map<String, List<Integer>> map = new HashMap<>();
        // info 데이터 처리
        for (String i : info) {
            String[] split = i.split(" ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
        }

        // 리스트 정렬
        for (Map.Entry<String, List<Integer>> l:map.entrySet()){
            System.out.println(l.getKey() + l.getValue());
        }
        
        
        
//         // 조건 저장
//         HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
//         for (int i=0;i<info.length;i++){
//             String[] splitedInfo = info[i].split(" ");
//             String lang = splitedInfo[0];
//             String part = splitedInfo[1];
//             String career = splitedInfo[2];
//             String food = splitedInfo[3];
//             score[i] = Integer.parseInt(splitedInfo[4]);
//             for (int a=0;a<2;a++){
//                 for (int b=0;b<2;b++){
//                     for (int c=0;c<2;c++){
//                         for (int d=0;d<2;d++){
//                             if (a==0) lang = "-";
//                             if (b==0) part = "-";
//                             if (c==0) career = "-";
//                             if (d==0) food = "-";
//                             String key = lang + " " + part +" " + career +" " + food;
//                             ArrayList<Integer> list = hm.getOrDefault(key, new ArrayList<>());
//                             list.add(score[i]);
//                             hm.put(key, list);
                            
//                             lang = splitedInfo[0];
//                             part = splitedInfo[1];
//                             career = splitedInfo[2];
//                             food = splitedInfo[3];
//                          }
//                     }
//                 }
//             }
//         }
        
//         for (Map.Entry<String, ArrayList<Integer>> l:hm.entrySet()){
//             Collections.sort(l.getValue());
//         }
        
//         String[] querySplit = new String[query.length];
//         int[] queryScore = new int[query.length];
//         for (int i=0;i<query.length;i++){            
//             String[] sq = query[i].split(" and ");
//             String[] subCond = sq[3].split(" ");
//             querySplit[i] ="";
//             for (int j=0;j<3;j++){
//                 querySplit[i] += sq[j] +" ";
//             }
//             querySplit[i] += subCond[0];
//             queryScore[i] = Integer.parseInt(subCond[1]);
//         }
        
//         for (int i=0;i<query.length;i++){
//             ArrayList<Integer> list = hm.get(querySplit[i]);
//             int left = 0;
//             int right = list.size();
//             while (left<right){
//                 int mid = (left + right) / 2;
//                 if (list.get(mid) >= queryScore[i]){
//                     right = mid;
//                 } else left = mid + 1;
//             }
//             answer[i] = list.size() - left;
//         }
    
      
        return answer;
    }
}