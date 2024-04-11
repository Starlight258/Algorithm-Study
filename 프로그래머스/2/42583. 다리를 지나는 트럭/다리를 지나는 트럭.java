import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0;i<bridge_length;i++) queue.offer(0);
        int tPos = 0; // 트럭
        int time = 0;
        int available = weight;
        while (tPos<truck_weights.length){
            time++;
            available += queue.poll();
            if (available >= truck_weights[tPos]){
                available -= truck_weights[tPos];
                queue.offer(truck_weights[tPos]);
                tPos++;
            } else queue.offer(0);
            if (tPos == truck_weights.length){
                time += bridge_length;
            }
            
        }
        return time;
    }
}