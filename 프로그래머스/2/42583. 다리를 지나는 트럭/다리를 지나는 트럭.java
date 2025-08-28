import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int curTime = 0;
        Deque<Integer> bridge = new ArrayDeque<>();
        int total = 0;
        for (int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        int index = 0;
        int n = truck_weights.length;
        while (index<n){
            curTime++;
            total -= bridge.pollFirst();
            if (weight - total >= truck_weights[index]){
                bridge.offerLast(truck_weights[index]);
                total += truck_weights[index];
                index++;
            } else {
                bridge.offerLast(0);
            }
        }
        
        while (!bridge.isEmpty() && total != 0){
            curTime++;        
            total -= bridge.pollFirst();
        }
        
        return curTime;
    }

    // 1. 다리에 bridge_length만큼 0 채우기
    // 2. 차가 올라가면 kg 추가
    // 3. 초마다 pop후, weight - kg >= 새로 추가된 트럭 무게 : 일 경우 kg추가, 그렇지 않을 경우 0 추가
    // ArrayDeque
}