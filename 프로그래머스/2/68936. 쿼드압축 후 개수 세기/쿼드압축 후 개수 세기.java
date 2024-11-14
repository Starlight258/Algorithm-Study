class Solution {
    
    private void check(int[][] arr, int n, int[] answer, int startY, int startX){
        boolean isSame = true;
        int sum = 0;
        int val = arr[startY][startX];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (arr[startY+i][startX+j] != val) {
                    isSame = false;
                    break;
                }
                sum += val;
            }
            if (!isSame){
                break;
            }
        }
        if (isSame){
            if(sum==0) answer[0]++;
            else answer[1]++;
            return;
        }
        
        n /=2;
        check(arr, n, answer, startY, startX);
        check(arr, n, answer, startY, startX+n);
        check(arr, n, answer, startY+n, startX);
        check(arr, n, answer, startY+n, startX+n);
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        int[][] counts = new int[n][n];
        check(arr, n, answer, 0, 0);
        return answer;
    }
}