class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int curIndex = n-1;
        int pickupIndex = n-1;
        int curDrop = cap;
        int curDeliv = cap;
        while (true){
            curDrop = cap;
            curDeliv = cap;
            if (curIndex<0 && pickupIndex<0){
                break;
            }
            
            while (curIndex>=0){
                int d = deliveries[curIndex]; // 배달할 상자
                if (d!=0){
                    break;
                } else {
                    curIndex--;
                }
            }
            int maxCurIndex=curIndex;
            while (curIndex>=0){
                int d = deliveries[curIndex]; // 배달할 상자
                if (d==0){
                    curIndex--;
                    continue;
                }
                if (d <= curDeliv){ 
                    curDeliv -=d;
                    deliveries[curIndex] = 0;
                    curIndex--;
                } else { // 더 상자가 많으면
                    deliveries[curIndex] -= curDeliv;
                    curDeliv = 0;
                    break;
                }
            }
            
            
            while (pickupIndex>=0){
                int d = pickups[pickupIndex]; // 배달할 상자
                if (d!=0){
                    break;
                } else {
                    pickupIndex--;
                }
            }
            int maxPickupIndex=pickupIndex;
            
            while (pickupIndex>=0){
                int d = pickups[pickupIndex]; // 수거할 상자
                if (d==0){
                    pickupIndex--;
                    continue;
                }
                if (d <= curDrop){
                    curDrop -=d;
                    pickups[pickupIndex] = 0;
                    pickupIndex--;
                } else { // 더 상자가 많으면
                    pickups[pickupIndex] -= curDrop;
                    curDrop = 0;
                    break;
                }
            }
            int val = Math.max(maxCurIndex, maxPickupIndex);
            answer += (Math.max(maxCurIndex, maxPickupIndex)+1) * 2; // 거리 저장
            
        }
        
        return answer;
    }
    // n개의 집 배달
    // 위치 : 인덱스(i)
    // 집 도착 : 배달 + 수거 
    // 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
    // cap = 재활용 택배 상자 개수, 수거할 택배 상자 개수 (각각)
    // 배달할 상자 개수 : deliveries
    // 수거할 상자 개수 : pickups
    // 그리디 : 가장 먼 곳부터 택배 상자 가져감 
    // 1. 택배가 존재하는 가장 먼 곳에서 cap만큼 가져감 (배달 + 수거), 인덱스+1만큼 거리 저장
    // 2. 
}