class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int totalD = 0; int totalC = 0;
        for (int i=n-1;i>=0;i--){
            totalD += deliveries[i];
            totalC += pickups[i];
            while (totalD >0 || totalC >0){ // 용량이 모두 채워지는 순간(음수->양수)
                totalD -= cap;
                totalC -= cap;
                answer += (i+1)*2; // 거리 업데이트
            }
        }
        return answer;
    }
}