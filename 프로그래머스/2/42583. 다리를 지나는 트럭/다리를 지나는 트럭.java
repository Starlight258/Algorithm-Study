import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int total = 0;
        for (int i=0;i<bridge_length-1;i++){
            bridge.offer(0);
        }
        int curTime = 1;
        int index = 1;
        int n = truck_weights.length;
        bridge.offerLast(truck_weights[0]);
        total += truck_weights[0];
        while (total!=0){
            curTime++;
            total -= bridge.pollFirst();
            if (index==n){
                continue;
            }
            if (weight - total >= truck_weights[index]){
                bridge.offerLast(truck_weights[index]);
                total += truck_weights[index];
                index++;
            } else {
                bridge.offerLast(0);
            }
        }
        
        return curTime;
    }

    // 1. 다리에 bridge_length만큼 0 채우기
    // 2. 차가 올라가면 kg 추가
    // 3. 초마다 pop후, weight - kg >= 새로 추가된 트럭 무게 : 일 경우 kg추가, 그렇지 않을 경우 0 추가
    // ArrayDeque
}