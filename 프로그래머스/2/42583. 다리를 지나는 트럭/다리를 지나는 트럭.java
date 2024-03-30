import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentBridgeWeight = 0;
        int index = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while (index < truck_weights.length) {
            currentBridgeWeight -= bridge.poll();
            
            if (currentBridgeWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                currentBridgeWeight += truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
            time++;
        }
        
        return time + bridge_length;
    }
}