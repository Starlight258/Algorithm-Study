import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // 1. 저장하기
        Map<String, Integer> mp = new HashMap<>(); // 장르별 저장횟수
        Map<String, List<Integer>> imp = new HashMap<>(); // 장르별 인덱스
        for (int i=0;i<genres.length;i++){
            mp.put(genres[i], mp.getOrDefault(genres[i], 0) + plays[i]);
            imp.computeIfAbsent(genres[i], k->new ArrayList<>()).add(i);
        }
        
        // 재생 횟수 많은 장르부터 정렬
        List<String> sortedGenres = new LinkedList<>(mp.keySet());
        Collections.sort(sortedGenres, (l1, l2) -> mp.get(l2) - mp.get(l1));
        
        // 장르별 재생횟수 + 고유번호 낮은 순으로 정렬
        for (String genre:sortedGenres){
            List<Integer> indexes = imp.get(genre);
            indexes.sort((a,b) -> plays[b] - plays[a]);
            
            answer.add(indexes.get(0));
            if (indexes.size()>1) answer.add(indexes.get(1));
        }
        
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}