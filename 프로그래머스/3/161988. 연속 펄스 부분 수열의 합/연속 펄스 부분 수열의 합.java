class Solution {
    public long solution(int[] sequence) {
        long min = 0;
        long max = 0;
        long sum = 0;
        int[] pulseSequence1 = new int[sequence.length];
        int[] pulseSequence2 = new int[sequence.length];
        for (int i=0;i<sequence.length;i++){
            pulseSequence1[i] = sequence[i] * (i%2==0?1:-1);
            pulseSequence2[i] = sequence[i] * (i%2==0?-1:1);
        }        
        long dp1[] = new long[pulseSequence1.length];
        long dp2[] = new long[pulseSequence2.length];
        dp1[0] = pulseSequence1[0];
        dp2[0] = pulseSequence2[0];
        long max1=dp1[0], max2=dp2[0];
        long min1=0, min2=0;
        for (int i=1;i<dp1.length;i++){
            dp1[i] = pulseSequence1[i] + dp1[i-1];
            max1 = Math.max(max1, dp1[i]);
            min1 = Math.min(min1, dp1[i]);
            
            dp2[i] = pulseSequence2[i] + dp2[i-1];
            max2 = Math.max(max2, dp2[i]);
            min2 = Math.min(min2, dp2[i]);
        } 
        
        return Math.max(max1 - min1, max2-min2);
    }
}