class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        // 1. 배달할 박스와 수거할 박스 합 저장
        int totalD = 0; int totalC = 0;
        for (int i=0;i<n;i++){
            totalD += deliveries[i];
            totalC += pickups[i];
        }
        //2. 돌아다니면서 수거하기
        int soFarD = 0; int soFarC = 0;
        int posD = n-1; int posC = n-1;
        int startD = posD; int startC = posC;
        while (true){
            int remainD = cap; int remainC = cap;
            if (totalD == soFarD && totalC == soFarC) break;
            // 택배 배달하기
            while (posD-1>=0 && deliveries[posD]==0){
                posD--;
            }
            startD = posD; //택배 배달 시작할 위치
            for (;posD>=0;posD--){
                int num = Math.min(deliveries[posD], remainD);
                remainD -= num;
                deliveries[posD] -= num;
                soFarD += num;
                if (remainD == 0) break;
            }
            
            // 택배 수거하기
            while (posC-1>=0 && pickups[posC]==0){
                posC--;
            }
            startC = posC; //택배 수거 시작할 위치
            for (;posC>=0;posC--){
                int num = Math.min(pickups[posC], remainC);
                remainC -= num;
                pickups[posC] -= num;
                soFarC += num;
                if (remainC == 0) break;
            }
            distance += (Math.max(startD, startC) + 1) * 2;
        }
        return distance;
    }
}