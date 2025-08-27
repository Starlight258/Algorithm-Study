import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> gen = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        for (int i=0;i<genres.length;i++){
            String g = genres[i];
            gen.put(g, gen.getOrDefault(g, 0) + plays[i]);
            songs.computeIfAbsent(g, k->new ArrayList<>()).add(new int[]{i,plays[i]});
        }
        // 인기 장르별로 정렬
        List<Map.Entry<String, Integer>> keys = new LinkedList<>(gen.entrySet());
        Collections.sort(keys, (o1, o2)-> {
            return Integer.compare(o2.getValue(), o1.getValue());
        });
        for (Map.Entry<String, Integer> k:keys){
            String genre = k.getKey();
            // 가장 조회수가 많은 노래 2개 조회
            List<int[]> song = songs.get(genre);
            Collections.sort(song, (s1,s2)-> Integer.compare(s2[1], s1[1]));
            answer.add(song.get(0)[0]);
            if (song.size()>1){
                answer.add(song.get(1)[0]);
            } 
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    // 1. 장르별 조회수 합 계산 (Map<String, Integer> )
    // 2. 인기 장르별로 가장 많이 재생된 노래 수록 -> 재생수가 같을 경우 고유번호가 낮은 노래 수록
    // Map<String, List<Integer>> -> 정렬시 오름차순, 고유번호가 낮은 순으로 정렬
}