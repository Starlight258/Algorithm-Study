import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight=0;
        int pos = 0;
        Queue<Integer> bridge = new LinkedList<>();
        // 다리 초기화 (1초에 1만큼 움직일 수 있다. 무게를 저장한다.)
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        // 다리 건너기 시작한다.
        while (pos < truck_weights.length){
            currentWeight -= bridge.poll();
            if (truck_weights[pos] + currentWeight <= weight){
                currentWeight += truck_weights[pos];
                bridge.offer(truck_weights[pos]);
                pos++;
            } else{
                bridge.offer(0);
            }
            answer++; // 시간 흐름
        }
        
        
        return answer + bridge_length;
    }
}