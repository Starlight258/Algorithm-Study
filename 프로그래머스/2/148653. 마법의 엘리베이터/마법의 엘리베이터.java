class Solution {
    public int solution(int storey) {
        int answer = 0;
        int currentDigit = 0;
        
        while (storey > 0){
            currentDigit = storey%10;
            storey /= 10;
            
            if (currentDigit<5){
                answer += currentDigit;
            } else if (currentDigit>5){
                answer += (10-currentDigit);
                storey++;
            } else {
                answer += 5;
                if ((storey%10) >= 5) storey++;                
            }
        }
        return answer;
    }
}