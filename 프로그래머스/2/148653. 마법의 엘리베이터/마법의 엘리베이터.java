class Solution {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0){
            int n = storey % 10;
            storey /= 10;
            // 5일 경우
            if(n == 5){
                answer += 5;
                if((storey%10) >= 5){
                    storey++;
                }
            }
            // 5보다 클 경우
            else if(n > 5){
                answer += (10-n);
                storey++;
            } else { // 5보다 작을 경우
                answer += n;
            }
        }
        return answer;
    }
}
