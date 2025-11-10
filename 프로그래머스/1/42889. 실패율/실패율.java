import java.util.*;

class Solution {

    class Stage implements Comparable<Stage> {
        
        int number;
        double failRate;
        
        Stage(int number, double failRate){
            this.number = number;
            this.failRate = failRate;
        }
        
        public int compareTo(Stage o){
            if (this.failRate == o.failRate){
                return Integer.compare(this.number, o.number);
            }
            return Double.compare(o.failRate, this.failRate);
        }
    }
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Double> fails = new HashMap<>();
        List<Stage> st = new ArrayList<>();
        for (int stage = 1;stage<=N;stage++){
            double reachPlayer = 0.0;
            double notClearPlayer = 0.0;
            
            for (int level:stages){
                if (level==stage){ // 도달하였지만클리어하지못한 플레이어수
                    notClearPlayer++;
                }
                if (level >= stage){
                    reachPlayer++;
                }
            }
            if (reachPlayer==0){
                st.add(new Stage(stage, 0.0));
                continue;
            } 
            st.add(new Stage(stage, notClearPlayer / reachPlayer));
        }
        Collections.sort(st);
        for (Stage s:st){
            answer.add(s.number);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
    // 실패율 = 도달하였지만클리어하지못한 플레이어수 / 스테이지에 도달한 플레이어수
    // 실패율 -> 번호 오름차순 
    // 스테이지 도달 안했을 경우 0
    // 실패율 구하기
    // 내림차순 정렬하기
}