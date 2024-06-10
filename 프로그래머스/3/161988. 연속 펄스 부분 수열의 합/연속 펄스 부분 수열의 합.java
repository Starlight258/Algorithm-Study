class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] pulseArray = new int[sequence.length];
        long min = 0;
        long max = 0;
        long sum = 0;
        for (int i=0;i<sequence.length;i++){
            sum += sequence[i] * (i%2==0?1:-1);
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }        
        return max - min;
    }
}