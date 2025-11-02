import java.util.*;

class Solution {
    
    private final Map<Integer, List<Integer>> outdegree = new HashMap<>();
    private final Map<Integer, List<Integer>> indegree = new HashMap<>();
    private int[] answer;

    public int[] solution(int[][] edges) {
        answer = new int[4];
        int n = 0;
        for (int[] e : edges) {
            if (e[0] > n) n = e[0];
            if (e[1] > n) n = e[1];
        }
        for (int i=1;i<=n;i++){
            outdegree.put(i, new ArrayList<>());
            indegree.put(i, new ArrayList<>());
        }
        for (int[] edge:edges){
            outdegree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        // 1. 출발점 찾기
        int start =  findStart(outdegree, indegree);
        answer[0] = start;
        List<Integer> points = outdegree.get(start);
        
        // 2. 그래프 확인하기
        for (int i=1;i<=n;i++){
            if (i==start) continue;
            int indegreeLength = indegree.get(i).size();
            int outdegreeLength = outdegree.get(i).size();
            if (outdegreeLength >=2){ // 8자
                answer[3]++;
            }
            if (outdegreeLength==0 && indegreeLength>=1){
                answer[2]++;
            }
        }
        answer[1] = points.size() - answer[2] - answer[3];
        
        return answer;
    }
    
    private int findStart(final Map<Integer, List<Integer>> outdegree, final Map<Integer, List<Integer>> indegree){
        List<Integer> candidates = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: outdegree.entrySet()){
            if (entry.getValue().size()>=2){
                candidates.add(entry.getKey());
            }
        }
        for (Integer cand : candidates){
            if (indegree.get(cand).size()==0){
                return cand;
            }
        }
        return -1;
    }
}


// 도넛 모양 그래프 : n개의 정점, n개의 간선 : 나가고 들어오는 거 하나
// 막대 모양 그래프 : n개의 정점과 n-1 간선 : 
// 8자 모양 그래프 : 2n+1 개의 정점, 2n+2개의 간선 :  나가고 들어오는 거 하나
// [생성한 정점의 번호, 도넛 모양 그래프 수, 막대 모양 그래프 수, 8자 모양 그래프 수]
// indegree : 0, outdegree >= 2 : 시작점 
// 8자: outdegree>=2
// 막대 : outdegree = 0특이점 : 꼬리 정점 존재
// 빡구현?