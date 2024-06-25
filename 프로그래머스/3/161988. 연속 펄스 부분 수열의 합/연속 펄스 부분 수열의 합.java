class Solution {
    public long solution(int[] sequence) {
        //1. 펄스 수열 구하기
        long[] pulse1 = new long[sequence.length];
        long[] pulse2 = new long[sequence.length];
        for (int i=0;i<sequence.length;i++){
            long s = sequence[i];
            if (i%2==0){
                pulse1[i] = s * 1;
                pulse2[i] = s * -1;
            } else {
                pulse1[i] = s * -1;
                pulse2[i] = s * 1;
            }
        }
        long answer = Math.max(pulse1[0], pulse2[0]);
        //2. dp 수행
        for (int i=1;i<pulse1.length;i++){
            pulse1[i] = Math.max(pulse1[i], pulse1[i-1]+pulse1[i]);
            pulse2[i] = Math.max(pulse2[i], pulse2[i-1]+pulse2[i]);
            answer = Math.max(answer, Math.max(pulse1[i], pulse2[i]));
        }
        
        return answer;
    }
}