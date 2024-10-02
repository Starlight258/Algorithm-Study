class Solution {
    private long[] length;
    private long[] oneCount;
    
    public int solution(int n, long l, long r) {
        init(n);
        return (int) countOnes(n, l, r);
    }
    
    private void init(int n){
        length = new long[n+1];
        oneCount = new long[n+1];
        length[0] = 1;
        oneCount[0] = 1;
        for (int i=1;i<=n;i++){
            length[i] = length[i-1] * 5; // 길이
            oneCount[i] = oneCount[i-1] * 4; // 1의 개수
        }
    }
    
    private long countOnes(int n, long start, long end){
        if (n==0) return 1;
        if (start > end) return 0;
        
        long count = 0;
        long unit = length[n-1]; // 이전 단계의 비트열 길이
        
        for (int i=0;i<5;i++){ // 11011
            long left = unit * i + 1;
            long right = unit * (i+1);
            
            if (end < left || right < start) continue;
            if (i==2) continue; // 0일때
            
            if (start <= left && right <= end){ // 범위가 완전히 포함될 경우
                count += oneCount[n-1]; 
            } else { // 부분적으로 겹칠 경우 더 작은 단계로 분할 정복
                count += countOnes(n-1, start-left+1, end-left+1);
            }
        }
        return count;
        
    }
}