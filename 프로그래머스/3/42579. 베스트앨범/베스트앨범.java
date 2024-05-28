import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 1. 저장하기
        // 장르별 재생횟수 저장
        Map<String, Integer> mp1 = new HashMap<>();
        // 장르별 노래 인덱스 저장
        Map<String, List<Integer>> mp2 = new HashMap<>();
        for (int i=0;i<plays.length;i++){
            mp1.put(genres[i], mp1.getOrDefault(genres[i], 0) + plays[i]);
            mp2.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }
        
        //2. 장르별 총 재생횟수 내림차순 정렬하기
        List<String> sortedGenres = new ArrayList<>(mp1.keySet());
        sortedGenres.sort((g1, g2) -> mp1.get(g2) - mp1.get(g1));
        
        // 해당 장르의 재생횟수별로 노래 정렬하기
        for (String genre:sortedGenres){
            List<Integer> indexes = mp2.get(genre);
            indexes.sort((i1, i2) -> plays[i2] -plays[i1]);
            
            answer.add(indexes.get(0));
            if (indexes.size()>1) answer.add(indexes.get(1));
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}