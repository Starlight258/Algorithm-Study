import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov:scoville){
            pq.offer(scov);
        }
        while (!pq.isEmpty()){
            int s1 = pq.poll();
            if (s1>=K){
                break;
            }
            if (pq.isEmpty()){
                return -1;
            }
            
            int s2 = pq.poll();
            int s3 = s1 + s2 * 2;
            pq.offer(s3);
            answer++;
        }
        return answer;
    }
    // 모든 음식의 스코빌 지수를 K 이상으로
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
    // K 10억
    // scoville 100만
    // 작은거 2개 pop -> 큰거 1개 만들기
    // 가장 작은게 K 이상이 될때까지 
    // 정렬 -> 우선순위큐 
}